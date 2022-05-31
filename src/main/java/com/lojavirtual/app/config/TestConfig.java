package com.lojavirtual.app.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lojavirtual.app.model.Users;
import com.lojavirtual.app.service.UsersService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UsersService service;
	
	public TestConfig(UsersService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		Users user1 = new Users(null, "Saci", "saci@email.com", "11912345678", "Saci1234");
		Users user2 = new Users(null, "Fox", "fox@email.com", "11998765432", "Fox9876");
		
		service.saveAll(Arrays.asList(user1, user2));		
	}
	
	
	
}
