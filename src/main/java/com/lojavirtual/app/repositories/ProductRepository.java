package com.lojavirtual.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
