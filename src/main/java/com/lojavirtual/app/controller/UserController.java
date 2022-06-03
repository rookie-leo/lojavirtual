package com.lojavirtual.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lojavirtual.app.controller.dto.request.UsersRequest;
import com.lojavirtual.app.controller.dto.response.UsersResponse;
import com.lojavirtual.app.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsersService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<UsersResponse>> findAll() {		
		List<UsersResponse> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersResponse> findById(@PathVariable Long id) {
		UsersResponse user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<UsersResponse> newUser(@RequestBody UsersRequest request) {
		UsersResponse user = new UsersResponse(service.save(request));
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(user);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsersResponse> update(@PathVariable Long id, @RequestBody UsersRequest request) {
		UsersResponse user = service.update(id, request);
		return ResponseEntity.ok().body(user);
	}
	
}
