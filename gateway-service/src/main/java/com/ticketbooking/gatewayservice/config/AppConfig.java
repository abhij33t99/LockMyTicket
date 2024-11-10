package com.ticketbooking.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public RestClient getAuthClient() {
        return RestClient.builder()
                .baseUrl("localhost:8081")
                .build();
    }
}
