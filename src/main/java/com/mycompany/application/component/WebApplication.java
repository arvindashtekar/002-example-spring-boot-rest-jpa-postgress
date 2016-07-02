package com.mycompany.application.component;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//NOTE: @SpringBootApplication is a alternative for @Configuration, @EnableAutoConfiguration and @ComponentScan. Probably you want use @Configuration + @ComponentScan. If you want load xml configuration you can use: @ImportResource annotation. If you want use autoconfiguration, but you can disable a few auto configurations, eg:  @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Configuration
@ComponentScan(basePackages = { "boot.configuration",
		"com.mycompany.application.component.controllers",
		"com.mycompany.application.component.services",
		})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.mycompany.application.component.repositories" })
@EntityScan(basePackages = {"com.mycompany.application.component.domain"})
public class WebApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);      
		
		/* To see which beans definitions available, */
		System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        /* END - To see which beans definitions available */
	}
}
