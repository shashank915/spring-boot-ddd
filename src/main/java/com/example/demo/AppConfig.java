package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ace.registration.infrastructure", basePackageClasses = {Jsr310JpaConverters.class})
@EntityScan(basePackages = "com.ace.registration")
@ComponentScan(basePackages = {"com.ace.registration","com.ace.payment"})
public class AppConfig {
}