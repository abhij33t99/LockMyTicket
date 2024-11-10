package com.ticketbooking.theatreservice.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class ScalarConfig {

    @Bean
    public RuntimeWiringConfigurer configurer() {
        return c -> c
                .scalar(ExtendedScalars.GraphQLLong)
                .scalar(ExtendedScalars.Date)
                .scalar(ExtendedScalars.DateTime)
                .scalar(ExtendedScalars.LocalTime);
    }
}
