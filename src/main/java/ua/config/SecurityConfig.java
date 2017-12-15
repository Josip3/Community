package ua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ua.security.AuthenticationTokenFilter;
import ua.security.EntryPointUnauthorizedHandler;
import ua.service.impl.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//буде працювати тыльки з методами де поставлена анотація PreAuthorize
//@ComponentScan("ua.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    public void configureAuth(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(this.userDetailsService);
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable();//шоб при кожному запиты не надсилати токен
                http.exceptionHandling()
                .authenticationEntryPoint(this.entryPointUnauthorizedHandler).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()//на які запити буде працювати секюріті
                .antMatchers("/*").permitAll()//доступ на сторінку для  всіх
                .antMatchers("/community**").authenticated()//перевіряє чи в юзера роль адміна
                .anyRequest().permitAll();//будь які роли



        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public     void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/js/**", "/css/**", "/img/**", "/error/**", "/gallery/**", "/file/**", "/game/**");
    }


    @Autowired
    public     void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder encoder) throws Exception {
      auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN_ROLE");
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder);

    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilter() throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter  = new AuthenticationTokenFilter();

        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }
}