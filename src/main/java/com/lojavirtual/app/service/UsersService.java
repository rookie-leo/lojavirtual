package com.lojavirtual.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.controller.dto.request.UsersRequest;
import com.lojavirtual.app.controller.dto.response.UsersResponse;
import com.lojavirtual.app.model.Users;
import com.lojavirtual.app.repositories.UsersRepository;
import com.lojavirtual.app.service.exceptions.DataBaseException;
import com.lojavirtual.app.service.exceptions.ResourceNotFoundExceptions;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	public List<UsersResponse> findAll() {
		List<UsersResponse> response = new ArrayList<UsersResponse>();

		repository.findAll().forEach(user -> {
			response.add(new UsersResponse(user));
		});

		return response;
	}

	public UsersResponse findById(Long id) {
		try {
			Optional<Users> user = repository.findById(id);
			UsersResponse response = new UsersResponse(user.get());

			return response;
		} catch (RuntimeException ex) {
			throw new ResourceNotFoundExceptions(id);
		}
	}

	public Users save(UsersRequest request) {
		Users user = request.toModel();
		return repository.save(user);
	}

	/**
	 * method created to use the config class
	 * */
	@Deprecated
	public void saveAll(List<Users> users) {
		repository.saveAll(users);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundExceptions(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataBaseException(ex.getMessage());
		}
	}

	public UsersResponse update(Long id, UsersRequest user) {
		Users entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions(id));

		updateData(entity, user);
		
		UsersResponse response = new UsersResponse(repository.save(entity));
		
		return response;
	}

	private void updateData(Users entity, UsersRequest user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

}
