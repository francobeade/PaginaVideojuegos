package com.francoBeade.PaginaVideojuegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PaginaVideojuegosApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PaginaVideojuegosApplication.class, args);
	}


}
