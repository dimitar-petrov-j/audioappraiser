package com.audioappraiser.audioapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AudioappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioappApplication.class, args);
//		System.out.println(DAL.CreateUpdateDelete_Object(1,"insert into users (username, real_name, is_private) values ('@0', '@1', '@2')",new String[]{"j-j", "Dimitar Petrov", "0"}));
//		System.out.println(DAL_ProjectsAndArtists.CreateUpdateDelete_Object(1,"insert into project (name, artist, artist_id, rating, reviews, release_date, type) values ('@0', '@1', '@2', '@3', '@4', '@5', '@6')",new String[]{"Flower Boy", "Tyler the Creator", "1", "3.89", "165", "2017-07-21", "ALBUM"}));
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/projects-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}
}
