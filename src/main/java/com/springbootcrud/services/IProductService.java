package com.springbootcrud.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.springbootcrud.data.dto.ProductDTO;
import com.springbootcrud.data.entity.*;

@Service
public interface IProductService {

	List<ProductDTO> getAllProducts();

	ProductEntity getProductbyID(long id);

	ProductEntity createProduct(ProductEntity product);

	ProductEntity updateProduct(long id, ProductEntity product);

	void deleteProductbyID(long id);

	Page<ProductEntity> getAllProducts(Integer no, Integer limit, String sortBy);

	List<ProductDTO> search(ProductDTO productDTO);

}
