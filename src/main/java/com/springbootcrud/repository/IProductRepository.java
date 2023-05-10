package com.springbootcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.springbootcrud.data.dto.ProductDTO;
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

	@Query("SELECT p FROM ProductEntity p JOIN p.category c "
			+ "WHERE (:name is null or lower(p.name) like %:#{#productDTO.name}%) "
			+ "AND (:description is null or lower(p.description) like %:#{#productDTO.description}%) "
			+ "AND (:categoryName is null or lower(c.name) like %:#{#productDTO.category.name}%)")
	List<ProductEntity> findByNameAndDescriptionAndCategoryName(@Param("productDTO") ProductDTO productDTO);

}
