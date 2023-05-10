package com.springbootcrud.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.springbootcrud.data.dto.ProductDTO;
import com.springbootcrud.data.dto.ProductSearchDTO;
import com.springbootcrud.data.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

//	@Query("SELECT COUNT(p) > 0 FROM product p WHERE p.name = :name", nativeQuery=true)
	boolean existsByName(@Param(value = "name") String name);

//	jpa naming convention 
//	@Query("SELECT COUNT(p) > 0 FROM ProductEntity p WHERE p.discription = :description")
	boolean existsByDiscription(@Param(value = "discription") String discription);

//	@Query("SELECT p FROM ProductEntity p "
//			+ "JOIN p.category c "
//			+ "WHERE (:name is null or lower(p.name) like %:name%) "
//			+ "AND (:discription is null or lower(p.discription) like %:discription%) "
//			+ "AND (:categoryName is null or lower(c.name) like %:categoryName%)")
//	List<ProductEntity> filter(@Param("name") String name,@Param("discription") String discription, @Param("categoryName") String categoryName);

//	@Query("SELECT p FROM ProductEntity p " + "JOIN p.category c "
//			+ "WHERE ((:keyword is null) or (lower(p.name) like %:keyword%) or (lower(p.discription) like %:keyword%)) "
//			+ "AND ((:categoryName is null) or (lower(c.name) like %:categoryName%)) ")
//	List<ProductEntity> filter(@Param("keyword") String keyword, @Param("categoryName") String categoryName);
	
	@Query("SELECT p FROM ProductEntity p " + "JOIN p.category c "
			+ "WHERE ((:keyword is null) or (lower(p.name) like %:keyword%) or (lower(p.discription) like %:keyword%)) "
			+ "AND ((:categoryName is null) or (lower(c.name) like %:categoryName%)) ")
	Page<ProductEntity> filter(@Param("keyword") String keyword, @Param("categoryName") String categoryName, Pageable page);


}
