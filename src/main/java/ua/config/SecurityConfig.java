package ua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.service.impl.UserDetailsServiceImpl;

/**
 * Created by cavayman on 08.04.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        http.addFilterBefore(filter, CsrfFilter.class);


        http
                .csrf().disable()//и з нашого сервера надісланий запит
                .authorizeRequests()// treba
                .antMatchers("/").permitAll()//доступ на сторінку для  всіх
                .antMatchers("/cm**").authenticated()//перевіряє чи в юзера роль адміна
                .anyRequest().permitAll()//будь які роли
                .and()
                .formLogin()
                .loginPage("/reg")
                .loginProcessingUrl("/loginprocesing")
                .usernameParameter("name")
                .passwordParameter("password")
                .failureUrl("/reg")
                .defaultSuccessUrl( "/cm", true)
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/reg").permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/js/**", "/css/**", "/img/**", "/error/**", "/gallery/**", "/file/**", "/game/**");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder encoder) throws Exception {
      auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN_ROLE");
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder);

    }
}