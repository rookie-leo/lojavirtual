package com.lojavirtual.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.app.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
