package com.krishna.product.test_learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public MyTestComponent myTestComponent(){
        return new MyTestComponent();
    }
}
