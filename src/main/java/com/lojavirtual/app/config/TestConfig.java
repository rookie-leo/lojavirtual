package com.lojavirtual.app.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lojavirtual.app.model.Order;
import com.lojavirtual.app.model.Users;
import com.lojavirtual.app.service.OrderService;
import com.lojavirtual.app.service.UsersService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UsersService userService;
	private OrderService orderService;
	
	public TestConfig(UsersService userService, OrderService orderService) {
		this.userService = userService;
		this.orderService = orderService;
	}

	@Override
	public void run(String... args) throws Exception {
		Users user1 = new Users(null, "Saci", "saci@email.com", "11912345678", "Saci1234");
		Users user2 = new Users(null, "Fox", "fox@email.com", "11998765432", "Fox9876");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1);
		
		userService.saveAll(Arrays.asList(user1, user2));
		orderService.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
	
	
	
}
