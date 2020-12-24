package com.training.ykb.order.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class RibonConfig {

    @Bean
    public IRule rule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing ping() {
        return new NoOpPing();
    }

}
