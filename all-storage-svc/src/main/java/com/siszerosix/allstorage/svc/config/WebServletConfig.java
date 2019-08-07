package com.siszerosix.allstorage.svc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author canyu
 * @data 2019/8/4 9:59
 */
@Configuration
@ComponentScan(basePackages = {
        "com.siszerosix.allstorage.svc.controller",
        "springfox.documentation.swagger.web"
})
public class WebServletConfig extends WebMvcConfigurationSupport {

    @Bean(name = "apiDispatcherServlet")
    public DispatcherServlet getDispatcherServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebServletConfig.class);
        dispatcherServlet.setApplicationContext(webContext);
        return dispatcherServlet;
    }

    @Bean(name = "API_SERVLET_REGISTRATION")
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(@Qualifier("apiDispatcherServlet") DispatcherServlet dispatcherServlet) {
        DispatcherServletRegistrationBean bean = new DispatcherServletRegistrationBean(dispatcherServlet, "/api/*");
        bean.setName("api_servlet");
        return bean;
    }

    @Bean(name = "SWAGGER_SERVLET_REGISTRATION")
    @Primary
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean2(@Qualifier("apiDispatcherServlet") DispatcherServlet dispatcherServlet) {
        DispatcherServletRegistrationBean bean = new DispatcherServletRegistrationBean(dispatcherServlet, "/*");
        bean.setName("swagger");
        return bean;
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
