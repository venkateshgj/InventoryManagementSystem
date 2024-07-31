package com.inventorymanagement.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.categories.Category;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1.0/products")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/all")
	Iterable<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/all/{id}")
	Optional<Product> getProductById(@PathVariable Long id) {
		return service.getProductById(id);
	}

	@GetMapping("/all/category/{categoryId}")
	List<Product> getAllProductsBycategoryId(@PathVariable Long categoryId) {
		return service.getAllProductsBycategoryId(categoryId);
	}

	@PostMapping("/all/{categoryId}")
	void addNewProduct(@RequestBody Product product, @PathVariable Long categoryId) {
		product.setCategory(new Category(categoryId));
		service.addNewProduct(product);
	}

	@PutMapping("/all/{productId}/{categoryId}")
	void updateProduct(@RequestBody Product product, @PathVariable Long categoryId) {
		product.setCategory(new Category(categoryId));
		service.updateProduct(product);
	}

	@DeleteMapping("/all/{id}")
	void deleteAProductById(@PathVariable Long id) {
		service.deleteAProductById(id);
	}
	
	@DeleteMapping("/all/category/{categoryId}")
	void deleteAllProductsByCategoryId(@PathVariable Long categoryId) {
		service.deleteAllProductsByCategoryId(categoryId);
	}
	
}
