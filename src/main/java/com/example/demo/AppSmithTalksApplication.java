package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.util.Constants;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class AppSmithTalksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSmithTalksApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value(Constants.APPSMITH_DEMO_DEVELOPED_BY) String appDesciption, @Value("1.0") String appVersion) {
		return new OpenAPI()
			.info(new Info()
			.title(Constants.TITLE)
			.version(appVersion)
			.description(appDesciption)
			.termsOfService("http://swagger.io/terms/")
			.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}