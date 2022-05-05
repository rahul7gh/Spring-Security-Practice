package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/*
 * Bhi meri baat sunnn...wheneevr you are changing anything that is being managed by Spring
 * you are defining a  custom configuration which overrides whatevr given by spring
 * In order for String to recognize this....it must be with @configgurationn class
 * otherwse you won't even know if it's getting applied.
 * It's better to use SOP statemnts or Logging etc to make sure methods
 * written by you are being executed. 
 * 
 */

// Keeping any extra nnotations configs in this main class is dicouraged .we'd like to have responsibilites spread out to different classs
//so put this on any other config class!.
//@EnableAsync
@SpringBootApplication()
public class AuthenticationLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationLayerApplication.class, args);
	}

}
