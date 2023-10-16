package com.imedia24.store.product;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeDataConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}

