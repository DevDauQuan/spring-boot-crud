package com.springbootcrud.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.data.entity.*;
import com.springbootcrud.repository.IProductRepository;
import com.springbootcrud.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository iProductRepository;

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return iProductRepository.findAll();
	}

	@Override
	public ProductEntity getProductbyID(long id) {
		// TODO Auto-generated method stub
		return iProductRepository.findById(id).get();
	}

	@Override
	public ProductEntity createProduct(ProductEntity product) {
		// TODO Auto-generated method stub
		return iProductRepository.save(product);
	}

	@Override
	public ProductEntity updateProduct(long id, ProductEntity product) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> oldProduct = iProductRepository.findById(id);
		if (oldProduct.isPresent()) {
			product.setId(id);
			return iProductRepository.save(product);
		}
			return null;
	}

	@Override
	public void deleteProductbyID(long id) {
		// TODO Auto-generated method stub
		iProductRepository.deleteById(id);
	}

}
