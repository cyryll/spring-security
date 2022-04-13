package com.example.springsecurity;

import com.example.springsecurity.domain.Role;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Doe", "John", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Doe1", "John1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Doe2", "John2", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Doe3", "John3", "1234", new ArrayList<>()));

			userService.addRoleToUser("John1", "ROLE_MANAGER");
			userService.addRoleToUser("John1", "ROLE_ADMIN");
			userService.addRoleToUser("John1", "ROLE_USER");
			userService.addRoleToUser("John3", "ROLE_USER");
			userService.addRoleToUser("John", "ROLE_USER");
			userService.addRoleToUser("John2", "ROLE_SUPER_ADMIN");
		};
	}
}
