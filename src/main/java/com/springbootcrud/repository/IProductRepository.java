package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootcrud.entities.ProductEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

}
