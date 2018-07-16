package com.frostinteractive.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    public static final Contact DEFAULT_CONTACT = new Contact(
//            "Shashank Kumar", "http://www.spring.io", "shashank@frostinteractive.com");
//
//    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
//            "RESTful Api Title", "RESTful API Description", "1.0",
//            "urn:tos", DEFAULT_CONTACT,
//            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
//
//    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
//            new HashSet<String>(Arrays.asList("application/json",
//                    "application/xml"));

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.frostinteractive"))
//                .paths(regex("/*"))
//                .build();
//    }
}
