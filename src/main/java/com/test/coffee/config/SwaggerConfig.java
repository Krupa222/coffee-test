package com.test.coffee.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Coffee test Api",
                description = "Coffee test application", version = "1.0.0",
                contact = @Contact(
                        name = "Krupskiy A.A."
                )
        )
)
public class SwaggerConfig {
}
