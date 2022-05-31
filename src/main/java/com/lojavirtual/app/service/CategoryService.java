package com.lojavirtual.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.model.Category;
import com.lojavirtual.app.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> category = repository.findById(id);
		
		if (category.isEmpty()) {
			throw new RuntimeException("Pedido não encontrado!");
		}
		
		return category.get();
	}
	
	public void save(Category category) {
		repository.save(category);
	}

	public void saveAll(List<Category> categorys) {
		repository.saveAll(categorys);		
	}
	
}
