package com.lojavirtual.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.model.Users;
import com.lojavirtual.app.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	public List<Users> findAll() {
		return repository.findAll();
	}

	public Users findById(Long id) {
		Optional<Users> user = repository.findById(id);
		
		if (user.isEmpty()) {
			throw new RuntimeException("Identificador de usuário não encontrado");
		}
		
		return user.get();
	}

	public void save(Users user) {
		repository.save(user);
	}

	public void saveAll(List<Users> users) {
		repository.saveAll(users);
	}
	
	public Users insert(Users user) {
		return repository.save(user);
	}

}
