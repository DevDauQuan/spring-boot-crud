package com.springbootcrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.data.dto.ProductDTO;
import com.springbootcrud.data.entity.ProductEntity;
import com.springbootcrud.services.IProductService;

@RestController
@RequestMapping("api/v1/product/")
public class ProductController {

	@Autowired
	IProductService service;

	@GetMapping("")
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return service.getAllProducts();
	}

	@GetMapping("/page")
	public Page<ProductEntity> getAllProducts(@RequestParam Integer no, @RequestParam Integer limit,
			@RequestParam String sortBy) {
		// TODO Auto-generated method stub
		return service.getAllProducts(no, limit, sortBy);
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

	@PostMapping("/search")
	public List<ProductDTO> search(@RequestBody ProductDTO productDTO) {
		return service.search(productDTO);
	}

}
