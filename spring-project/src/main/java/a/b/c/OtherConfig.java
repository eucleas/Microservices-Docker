package a.b.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {


    @Bean
    public OtherBeanA cotherBeanA() {
        return new OtherBeanA();

    }

}
