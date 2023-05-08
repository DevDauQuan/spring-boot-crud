package com.springbootcrud.services.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootcrud.data.entity.*;
import com.springbootcrud.exception.ExistsException;
import com.springbootcrud.exception.NotFoundException;
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
		Map<String, String> errors = new HashMap<String, String>();
		// TODO Auto-generated method stub
		if (iProductRepository.existsByName(product.getName())) {
			errors.put("name", product.getName());
			
		}
		if(iProductRepository.existsByDiscription(product.getDiscription())) {
			errors.put("discription", product.getDiscription());
		}
		if(errors.isEmpty()) {			
			return iProductRepository.save(product);
		}
		throw new ExistsException(errors);
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

	@Override
	public Page<ProductEntity> getAllProducts(Integer no, Integer limit, String sortBy) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(sortBy);
		return iProductRepository.findAll(PageRequest.of(no, limit, sort));
	}

}
