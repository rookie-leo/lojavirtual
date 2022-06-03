package com.lojavirtual.app.controller.dto.response;

import com.lojavirtual.app.model.Users;

public class UsersResponse {

	private Long id;
	private String name;
	private String email;
	private String phone;
	
	public UsersResponse(Users user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
}
