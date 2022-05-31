package com.lojavirtual.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.app.model.Users;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@GetMapping("/listar")
	public ResponseEntity<Users> findAll() {
		Users user = new Users(1L, "João", "joao@email.com", "123456789", "123456");
		
		return ResponseEntity.ok().body(user);
	}
	
}
