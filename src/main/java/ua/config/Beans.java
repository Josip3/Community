package ua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.service.utils.FileBuilder;

@Component
@Configuration
public class Beans {

    @Bean(name = "encoder")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FileBuilder fileBuilder(){
        return new FileBuilder();
    }

}