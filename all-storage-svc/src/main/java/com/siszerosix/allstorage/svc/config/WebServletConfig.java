package com.siszerosix.allstorage.svc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author canyu
 * @data 2019/8/4 9:59
 */
@Configuration
@ComponentScan(basePackages = {
        "com.siszerosix.allstorage.svc.controller",
})
@EnableWebMvc
public class WebServletConfig extends WebMvcConfigurationSupport {

    @Bean(name = "apiDispatcherServlet")
    public DispatcherServlet getDispatcherServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebServletConfig.class);
        dispatcherServlet.setApplicationContext(webContext);
        return dispatcherServlet;
    }

    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(@Qualifier("apiDispatcherServlet") DispatcherServlet dispatcherServlet) {
        DispatcherServletRegistrationBean bean = new DispatcherServletRegistrationBean(dispatcherServlet, "/api/*");
        bean.setName("api_servlet");
        return bean;
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
}
