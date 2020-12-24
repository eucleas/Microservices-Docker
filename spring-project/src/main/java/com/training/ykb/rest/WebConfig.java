package com.training.ykb.rest;

public class WebConfig {

}

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.cors()
//            .disable()
//            .csrf()
//            .disable()
//            .authorizeRequests()
//            .antMatchers("/actuator")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic();
//    }
//
//
//}
