package com.lojavirtual.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.model.OrderItem;
import com.lojavirtual.app.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	public List<OrderItem> findAll() {
		return repository.findAll();
	}
	
	public OrderItem findById(Long id) {
		Optional<OrderItem> item = repository.findById(id);
		
		if (item.isEmpty()) {
			throw new RuntimeException("Item de pedido não encontrado!");
		}
		
		return item.get();
	}
	
	public void save(OrderItem item) {
		repository.save(item);
	}
	
	public void saveAll(List<OrderItem> itens) {
		repository.saveAll(itens);
	}
	
}
