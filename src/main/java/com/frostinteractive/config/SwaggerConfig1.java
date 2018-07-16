package com.frostinteractive.config;

import io.swagger.annotations.*;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SwaggerDefinition(
        info = @Info(

                description = "Awesome Resources",
                version = "V12.0.12",
                title = "Frost Interactive API Docs",
                contact = @Contact(
                        name = "Shashank Kumar",
                        email = "shashank@frostinteractive.com",
                        url = "http://www.frostinteractive.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public class SwaggerConfig1 {
}
