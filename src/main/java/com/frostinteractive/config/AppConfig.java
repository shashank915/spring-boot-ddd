package com.frostinteractive.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.frostinteractive.registration.infrastructure", basePackageClasses = {Jsr310JpaConverters.class})
@EntityScan(basePackages = "com.frostinteractive.registration",basePackageClasses = Jsr310JpaConverters.class)
@ComponentScan(basePackages = {"com.frostinteractive.registration", "com.frostinteractive.payment"})
@Import({SwaggerConfig.class,WebMvcConfig.class})
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

}