package com.inventorymanagement.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagement.categories.Category;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;

	Iterable<Product> getAllProducts() {
		return repo.findAll();
	}

	Optional<Product> getProductById(Long id) {
		return repo.findById(id);
	}

//	List<Category> getProductsBycategoryId(Long categoryId) {
//		return repo.getByCategoryId(categoryId);
//	}
	
	void addNewProduct(Product product) {
		repo.save(product);		
	}

	void updateProduct(Product product) {
		repo.save(product);
	}

	void deleteAProduct(Long id) {
		repo.deleteById(id);
	}

}
