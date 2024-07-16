package com.example.SportWebFullStack.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer{
public void addCorsMapping(CorsRegistry registry) {
	registry.addMapping("/sport/**")
	.allowedOriginPatterns("*")
	.allowedMethods("GET","POST","DELETE","PUT")
	.allowedHeaders("*")
	.allowCredentials(true)
	.maxAge(3600);
}
}
