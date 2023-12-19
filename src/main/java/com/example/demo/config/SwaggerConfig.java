package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import java.util.List;


@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .servers(
                        List.of(
                                new Server().url("http://5.35.82.78:8080")
                        )
                )
                .info(
                        new Info().title("GraniAPI")
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ваш заголовок API")
                .description("Ваше описание API")
                .version("1.0")
                .build();
    }
}