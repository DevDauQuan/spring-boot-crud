package com.springbootcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.data.entity.*;
import com.springbootcrud.services.IProductService;

@RestController
@RequestMapping("api/v1/product/")
public class ProductController {

	@Autowired
	IProductService service;

	@GetMapping("")
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return service.getAllProducts();
	}

	@PostMapping("")
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		// TODO Auto-generated method stub
		return service.createProduct(product);
	}

	@GetMapping("{id}")
	public ProductEntity getProductbyID(@PathVariable long id) {
		// TODO Auto-generated method stub
		return service.getProductbyID(id);
	}

	@PutMapping("{id}")
	public ProductEntity updateProduct(@PathVariable long id, @RequestBody ProductEntity product) {
		// TODO Auto-generated method stub
		return service.updateProduct(id, product);
	}

	@DeleteMapping("{id}")
	public void deleteProductbyID(@PathVariable long id) {
		// TODO Auto-generated method stub
		service.deleteProductbyID(id);
	}

}
