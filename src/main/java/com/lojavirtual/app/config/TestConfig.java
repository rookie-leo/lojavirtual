package com.lojavirtual.app.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lojavirtual.app.model.Category;
import com.lojavirtual.app.model.Order;
import com.lojavirtual.app.model.Product;
import com.lojavirtual.app.model.Users;
import com.lojavirtual.app.model.enuns.OrderStatus;
import com.lojavirtual.app.service.CategoryService;
import com.lojavirtual.app.service.OrderService;
import com.lojavirtual.app.service.ProductService;
import com.lojavirtual.app.service.UsersService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UsersService userService;
	private OrderService orderService;
	private CategoryService categoryService;
	private ProductService productService;
	
	public TestConfig(UsersService userService, OrderService orderService, CategoryService categoryService, ProductService productService) {
		this.userService = userService;
		this.orderService = orderService;
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryService.saveAll(Arrays.asList(cat1, cat2, cat3));
		productService.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p5.getCategories().add(cat2);
		
		productService.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Users user1 = new Users(null, "Saci", "saci@email.com", "11912345678", "Saci1234");
		Users user2 = new Users(null, "Fox", "fox@email.com", "11998765432", "Fox9876");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.SHIPPED);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.PAID);
		
		userService.saveAll(Arrays.asList(user1, user2));
		orderService.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
