package com.audioappraiser.audioapp;

import com.audioappraiser.audioapp.modelrepos.primary.ArtistRepository;
import com.audioappraiser.audioapp.modelrepos.primary.ProjectRepository;
import com.audioappraiser.audioapp.modelrepos.secondary.RoleRepository;
import com.audioappraiser.audioapp.modelrepos.secondary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories("com.audioappraiser.audioapp.modelrepos")
@EntityScan("com.audioappraiser.audioapp.model")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AudioappApplication {
	public static void main(String[] args) {
		SpringApplication.run(AudioappApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/projects-javaconfig").allowedOrigins("http://localhost:8080");
				registry.addMapping("/projects-search").allowedOrigins("http://localhost:8080");
				registry.addMapping("/getusers").allowedOrigins("http://localhost:8080");
			}
		};
	}
}
