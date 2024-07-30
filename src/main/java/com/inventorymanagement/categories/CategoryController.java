package com.inventorymanagement.categories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.suppliers.Suppliers;

@RestController
@RequestMapping("/api/v1.0/categories")
public class CategoryController {
	
	@Autowired
	CategoryService service;

	@GetMapping("/all")
	Iterable<Category> getAllCategories() {
		return service.getAllCategories();
	}
	
	@GetMapping("/all/{id}")
	Optional<Category> getCategoryById(@PathVariable Long id) {
		return service.getCategoryById(id);
	}
	
	@PostMapping("/all")
	void addNewCategory(@RequestBody Category category) {
		service.addNewCategory(category);
	}
		
	@DeleteMapping("/all/{id}")
	void deleteACategoryById(@PathVariable Long id) {
		service.deleteACategoryById(id);
	}
}
