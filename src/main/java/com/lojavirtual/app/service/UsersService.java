package com.lojavirtual.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.model.Users;
import com.lojavirtual.app.repositories.UsersRepository;
import com.lojavirtual.app.service.exceptions.DataBaseException;
import com.lojavirtual.app.service.exceptions.ResourceNotFoundExceptions;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	public List<Users> findAll() {
		return repository.findAll();
	}

	public Users findById(Long id) {
		Optional<Users> user = repository.findById(id);
				
		return user.orElseThrow(() -> new ResourceNotFoundExceptions(id));
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
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundExceptions(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataBaseException(ex.getMessage());
		}
	}
	
	public Users update(Long id, Users user) {
		Users entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions(id));
		
		updateData(entity, user);
		
		return repository.save(entity);
	}

	private void updateData(Users entity, Users user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

}
