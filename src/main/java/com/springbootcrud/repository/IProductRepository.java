package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootcrud.data.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

//	@Query("SELECT COUNT(p) > 0 FROM product p WHERE p.name = :name", nativeQuery=true)
	boolean existsByName(@Param(value = "name") String name);

//	jpa naming convention 
//	@Query("SELECT COUNT(p) > 0 FROM ProductEntity p WHERE p.discription = :description")
	boolean existsByDiscription(@Param(value = "discription") String discription);
	
	
}
