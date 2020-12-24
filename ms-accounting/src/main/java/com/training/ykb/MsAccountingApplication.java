package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class MsAccountingApplication {

    @Scheduled(fixedDelay = 10_000)
    public void name() {
        System.out.println("Çalıştım");
    }

    public static void main(final String[] args) {
        SpringApplication.run(MsAccountingApplication.class,
                              args);
    }

}
