package com.lojavirtual.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojavirtual.app.model.Order;
import com.lojavirtual.app.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order FindById(Long id) {
		Optional<Order> order = repository.findById(id);
		
		if (order.isEmpty()) {
			throw new RuntimeException("Pedido não encontrado!");
		}
		
		return order.get();
	}
	
	public void save(Order order) {
		repository.save(order);
	}

	public void saveAll(List<Order> orders) {
		repository.saveAll(orders);		
	}
	
}
