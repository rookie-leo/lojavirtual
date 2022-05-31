package com.lojavirtual.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.app.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
