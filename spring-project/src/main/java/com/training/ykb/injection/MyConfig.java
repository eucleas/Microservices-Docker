package com.training.ykb.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import a.b.c.OtherConfig;

@Configuration
@Import(OtherConfig.class)
//@Profile("dev")
public class MyConfig {

    @Bean
    //@Primary
    @Qualifier("pokemon")
    public MyUsingBean createMyUsingBean() {
        return new MyUsingBean();
    }


    @Bean
    //@Primary
    @Qualifier("disney")
    public MyUsingBean myUsingBeanEx(final MyBean beanParam) {
        return new MyUsingBean(beanParam);
    }

}
