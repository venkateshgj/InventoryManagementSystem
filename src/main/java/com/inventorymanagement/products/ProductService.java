package com.inventorymanagement.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	List<Product> getAllProductsBycategoryId(Long categoryId) {
		return repo.findByCategoryCategoryId(categoryId);
	}
	
	List<Product> getAllProductsByWarehouseId(Long warehouseId) {
		return repo.findByWarehouseWarehouseId(warehouseId);
	}
	
	List<Product> getAllLowLevelProductsByWarehouseId(Long warehouseId, Integer level) {
		return repo.getAllLowLevelProductsByWarehouseId(warehouseId, level);
	}
	
	List<Product> getAllHighLevelProductsByWarehouseId(Long warehouseId, Integer level) {
		return repo.getAllHighLevelProductsByWarehouseId(warehouseId, level);
	}
	
	List<Product> getAllLowAndHighLevelProductsByWarehouseId(Long warehouseId) {
		return repo.getAllLowAndHighLevelProductsByWarehouseId(warehouseId);
	}
	
	void addNewProduct(Product product) {
		repo.save(product);		
	}

	void updateProduct(Product product) {
		repo.save(product);
	}

	void deleteAProductById(Long id) {
		repo.deleteById(id);
	}
	
	@Transactional
	void deleteAllProductsByCategoryId(Long categoryId) {
		repo.deleteAllProductsByCategoryId(categoryId);
	}

}