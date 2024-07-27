package com.inventorymanagement.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	void deleteACategoryById(Long id) {
		repo.deleteById(id);
	}
	
}
