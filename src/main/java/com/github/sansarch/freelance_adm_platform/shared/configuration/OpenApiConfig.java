package com.github.sansarch.freelance_adm_platform.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Freelance Administration Platform API")
                .version("1.0")
                .description("API documentation for the Freelance Administration Platform"));
    }
}
