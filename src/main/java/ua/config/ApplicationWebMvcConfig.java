package ua.config;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;

//import org.springframework.boot.context.embedded.MultipartConfigFactory;

@Configuration
@EnableWebMvc
public class ApplicationWebMvcConfig extends WebMvcConfigurerAdapter {

    InternalResourceViewResolver resolver = new InternalResourceViewResolver();

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean
    public InternalResourceViewResolver viewResolver() {
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        String rootPath = System.getProperty("catalina.home");
        registry.addResourceHandler("/res/**")
                .addResourceLocations("/WEB-INF/views/front/dist/")
                .addResourceLocations("/assets/**")
                .addResourceLocations("/")
               .addResourceLocations("/resources/**")
                .addResourceLocations("/resources/");
    }


    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {

        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });

        return tomcat;

    }

    @Bean
    public TemplateEngine templateEngine() {

        //templateEngine.setTemplateResolver();
        return new TemplateEngine();
    }



}