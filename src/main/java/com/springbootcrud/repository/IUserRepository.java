package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcrud.data.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
	
}
