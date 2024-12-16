package com.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "My Swagger Application",
				description = "Swagger Documentation",
				version = "v1",
				contact = @Contact(
						name = "Kiron",
						email= "kiron@gmail.com",
						url = "https://moonstar.com"

				)
		),
		servers = {
			@Server(
					url = "dev.moonstar.com",
					description = "Developer Server"
			),
			@Server(
					url = "staging.moonstar.com",
					description = "Staging Server"
			),
			@Server(
					url = "qa.moonstar.com",
					description = "Testing Server"
			),
			@Server(
					url = "prod.moonstar.com",
					description = "Production Server"
			)

		}
)
@SpringBootApplication
public class SwaggerDocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDocumentationApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
