package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcrud.data.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

}
