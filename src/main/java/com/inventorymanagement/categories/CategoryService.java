package com.inventorymanagement.categories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagement.products.Product;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repo;
	
	Iterable<Category> getAllCategories() {
		return repo.findAll();
	}

	Optional<Category> getCategoryById(Long id) {
		return repo.findById(id);
	}

	void addNewCategory(Category category) {
		repo.save(category);
	}
	void updateCategory(Category category) {
		repo.save(category);
	}

	void deleteACategoryById(Long id) {
		repo.deleteById(id);
	}
	
}
