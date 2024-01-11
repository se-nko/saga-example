package ru.senko.robotshop.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun api() : OpenAPI {
        return OpenAPI()
                .info(Info()
                        .title("Robot Shop API")
                        .description("OpenAPI v3")
                        .version("1.0")
                )
    }

}