package io.nativechef.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class NativeChef extends SpringBootServletInitializer {

	@RequestMapping("/hello")
	@ResponseBody
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(NativeChef.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(NativeChef.class, args);
	}
}
