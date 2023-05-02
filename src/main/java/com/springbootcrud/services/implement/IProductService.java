package com.springbootcrud.services.implement;

import java.util.List;

import com.springbootcrud.entities.ProductEntity;

public interface IProductService {

	public List<ProductEntity> getAllProducts();

	public ProductEntity getProductbyID(long id);

	public ProductEntity createProduct(ProductEntity product);

	public ProductEntity updateProduct(long id, ProductEntity product);
	
	public void deleteProductbyID(long id);

}
