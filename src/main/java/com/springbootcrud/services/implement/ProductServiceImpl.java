package com.springbootcrud.services.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootcrud.data.dto.ProductDTO;
import com.springbootcrud.data.dto.ProductSearchDTO;
import com.springbootcrud.data.entity.ProductEntity;
import com.springbootcrud.data.mapper.ProductMapper;
import com.springbootcrud.exception.ExistsException;
import com.springbootcrud.repository.IProductRepository;
import com.springbootcrud.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository iProductRepository;

	@Autowired
	ProductMapper mapper;

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub

		return iProductRepository.findAll().stream().map(p -> mapper.toDTO(p)).collect(Collectors.toList());
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
		if (iProductRepository.existsByDiscription(product.getDiscription())) {
			errors.put("discription", product.getDiscription());
		}
		if (errors.isEmpty()) {
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

//	@Override
//	public List<ProductDTO> search(String keyword, String categoryName) {
////		List<ProductDTO> products = iProductRepository
////				.filter(productDTO.getName(), productDTO.getDiscription(), productDTO.getCategoryName()).stream()
////				.map(p -> mapper.toDTO(p)).collect(Collectors.toList());
//		if(categoryName!=null) {
//			categoryName=categoryName.toLowerCase();
//		}
//		if(keyword!=null) {
//			keyword=keyword.toLowerCase();
//		}
//		List<ProductDTO> products = iProductRepository.filter(keyword, categoryName).stream().map(p -> mapper.toDTO(p))
//				.collect(Collectors.toList());
//		
//		if (products.isEmpty()) {
//			return null;
//		} else {
//			return products;
//		}
//	}

//	@Override
//	public List<ProductDTO> search(ProductDTO productDTO) {
//		List<ProductDTO> products = iProductRepository.findByNameLikeOrDiscriptionLikeOrCategory_NameLike(productDTO).stream()
//				.map(p -> mapper.toDTO(p)).collect(Collectors.toList());
//
//		if (products.isEmpty()) {
//			return null;
//		} else {
//			return products;
//		}
//	}

	@Override
	public Page<ProductDTO> search(String keyword, String categoryName, Integer no, Integer limit, String sortBy) {
//		List<ProductDTO> products = iProductRepository
//				.filter(productDTO.getName(), productDTO.getDiscription(), productDTO.getCategoryName()).stream()
//				.map(p -> mapper.toDTO(p)).collect(Collectors.toList());
		if (categoryName != null) {
			categoryName = categoryName.toLowerCase();
		}
		if (keyword != null) {
			keyword = keyword.toLowerCase();
		}
		Sort sort = Sort.by(sortBy);
		return iProductRepository.filter(keyword, categoryName, PageRequest.of(no, limit, sort)).map(p-> mapper.toDTO(p));

	}

}
