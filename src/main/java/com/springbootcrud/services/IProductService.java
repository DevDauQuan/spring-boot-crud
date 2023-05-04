package com.springbootcrud.services;

import java.util.List;

import com.springbootcrud.data.entity.*;

public interface IProductService {

	public List<ProductEntity> getAllProducts();

	public ProductEntity getProductbyID(long id);

	public ProductEntity createProduct(ProductEntity product);

	public ProductEntity updateProduct(long id, ProductEntity product);

	public void deleteProductbyID(long id);

}
