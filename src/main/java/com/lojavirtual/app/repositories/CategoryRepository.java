package com.lojavirtual.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
