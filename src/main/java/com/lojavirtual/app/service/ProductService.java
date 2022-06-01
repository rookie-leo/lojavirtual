package com.lojavirtual.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.model.Product;
import com.lojavirtual.app.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> product = repository.findById(id);
		
		if (product.isEmpty()) {
			throw new RuntimeException("Produto não cadastrado!");
		}
		
		return product.get();
	}
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public void saveAll(List<Product> products) {
		repository.saveAll(products);
	}
	
}
