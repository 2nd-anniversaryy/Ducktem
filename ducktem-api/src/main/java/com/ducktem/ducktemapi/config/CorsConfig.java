package com.ducktem.ducktemapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig {

	@Bean
	WebMvcConfigurer webMvcConfigurer(){
		WebMvcConfigurer configurer = new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registery){
				registery.addMapping("/**")
					.allowedOrigins("http://localhost:5174")
					.allowedMethods(
						HttpMethod.GET.name(),
						HttpMethod.POST.name(),
						HttpMethod.DELETE.name(),
						HttpMethod.PUT.name()
					);
			};
		};

		return configurer;
	}
}
