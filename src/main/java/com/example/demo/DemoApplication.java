package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket get(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/vehicle/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.build().apiInfo(createApiInfo());
	}

	private ApiInfo createApiInfo(){
		return new ApiInfo("Vehicle Api",
				"Vehicle database controll",
				"1.00",
				"https://github.com/00Zbiechu",
				new Contact("Mateusz","https://github.com/00Zbiechu","00zbiewski@gmail.com"),
				"My Own License",
				"https://github.com/00Zbiechu",
				Collections.emptyList());
	}

}
