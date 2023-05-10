package com.springbootcrud.data.mapper;

import org.springframework.stereotype.Component;

import com.springbootcrud.data.dto.CategoryDTO;
import com.springbootcrud.data.dto.ProductDTO;
import com.springbootcrud.data.entity.Category;
import com.springbootcrud.data.entity.ProductEntity;

@Component
public class ProductMapper {
	public ProductDTO toDTO(ProductEntity productEntity) {
		ProductDTO dto = new ProductDTO();
		dto.setName(productEntity.getName());
		dto.setDiscription(productEntity.getDiscription());
		// Create a new CategoryDTO and set its properties
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(productEntity.getCategory().getId());
		categoryDTO.setName(productEntity.getCategory().getName());
		dto.setCategoryDTO(categoryDTO);

		return dto;
	}

	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDTO.getName());
		productEntity.setDiscription(productDTO.getDiscription());

		CategoryDTO categoryDTO = productDTO.getCategoryDTO();
		Category categoryEntity = new Category();
		categoryEntity.setId(categoryDTO.getId());
		categoryEntity.setName(categoryDTO.getName());

		productEntity.setCategory(categoryEntity);
		return productEntity;
	}

}
