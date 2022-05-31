package com.lojavirtual.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
