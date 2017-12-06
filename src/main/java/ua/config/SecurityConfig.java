package ua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.service.impl.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//буде працювати тыльки з методами де поставлена анотація PreAuthorize
/*@ComponentScan("ua.")*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected  void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()//шоб при кожному запиты не надсилати токен    
                .authorizeRequests()// treba
                .antMatchers("/").permitAll()//доступ на сторінку для  всіх
                .antMatchers("/community**").authenticated()//перевіряє чи в юзера роль адміна
                .anyRequest().permitAll()//будь які роли
                .and()
                .formLogin()
                .loginPage("/reg")
                .loginProcessingUrl("/loginprocesing")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/reg")
                .defaultSuccessUrl( "/community", true)
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/reg").permitAll();
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
}