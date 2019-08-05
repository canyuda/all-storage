package com.siszerosix.allstorage.svc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author canyu
 * @data 2019/8/5 0:51
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    /**
     * 授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/online/**").denyAll()
                .anyRequest().permitAll();

//        http.formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/index")
//                .failureUrl("/login?error")
//                .permitAll()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(1209600)
//                .key("myKey")
//                .and()
//                .logout()
//                .logoutUrl("/cusstom-logout")
//                .logoutSuccessUrl("/logout-success")
//                .permitAll();


    }

    /**
     * 认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

    }


}
