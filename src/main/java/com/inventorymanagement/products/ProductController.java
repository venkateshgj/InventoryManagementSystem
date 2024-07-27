package com.inventorymanagement.products;

import java.util.List;
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

import com.inventorymanagement.categories.Category;

@RestController
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
	
	//This method is not working, there is some issue inside method that is present in Repository
//	@GetMapping("/all/category/{categoryId}")
//	List<Category> getProductsBycategoryId(@PathVariable Long categoryId) {
//		return service.getProductsBycategoryId(categoryId);
//	}
	
	@PostMapping("/all")
	void addNewProduct(@RequestBody Product product) {
		service.addNewProduct(product);
	}
	
	@PutMapping("/all/{id}")
    void updateProduct(@RequestBody Product product){
       service.updateProduct(product);
    }

    @DeleteMapping("/all/{id}")
    void deleteAProduct(@PathVariable Long id){
        service.deleteAProduct(id);
    }
}
