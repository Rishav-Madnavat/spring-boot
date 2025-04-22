package com.jeriv.springboot.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // Define API Metadata
    @Bean
    public GroupedOpenApi packageGroup() {
        return GroupedOpenApi.builder()
            .group("controllers")  // Define the group name
            .packagesToScan("com.jeriv.springboot.controller")  // Specify the package to scan
            .pathsToMatch("/employee/**")
            .build();
    }
}