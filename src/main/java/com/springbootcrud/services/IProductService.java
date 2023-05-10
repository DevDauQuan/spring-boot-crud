package com.springbootcrud.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springbootcrud.data.dto.ProductDTO;
import com.springbootcrud.data.entity.*;

public interface IProductService {

	List<ProductDTO> getAllProducts();

	ProductEntity getProductbyID(long id);

	ProductEntity createProduct(ProductEntity product);

	ProductEntity updateProduct(long id, ProductEntity product);

	void deleteProductbyID(long id);

	Page<ProductEntity> getAllProducts(Integer no, Integer limit, String sortBy);
	
	List<ProductEntity> search(String name, String discription);

}
