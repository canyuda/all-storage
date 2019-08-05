package com.siszerosix.allstorage.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author canyu
 */
@SpringBootApplication(exclude = {
        DispatcherServletAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
})
public class AllStorageApplication extends SpringBootServletInitializer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    public static void main(String[] args) {
        SpringApplication.run(AllStorageApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AllStorageApplication.class);
    }


    @Override
    protected WebApplicationContext run(SpringApplication application) {
        return super.run(application);
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8080);
        factory.setContextPath("/allstorage");
    }
}
