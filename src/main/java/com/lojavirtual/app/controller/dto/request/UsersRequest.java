package com.lojavirtual.app.controller.dto.request;

import javax.validation.constraints.NotBlank;

import com.lojavirtual.app.model.Users;

public class UsersRequest {

	private @NotBlank String name;
	private @NotBlank String email;
	private @NotBlank String phone;
	private @NotBlank String password;
	
	public UsersRequest(@NotBlank String name, @NotBlank String email, @NotBlank String phone,
			@NotBlank String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Users toModel() {
		return new Users(null, name, email, phone, password);
	}
	
}
