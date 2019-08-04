package com.siszerosix.allstorage.svc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author canyu
 * @data 2019/8/4 1:09
 */
@Configuration
public class MyServerConfig {

    @Value("${properties.owner}")
    private String owner;

    @Bean
    public String setOwner() {
        return owner;
    }


}
