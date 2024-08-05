package com.inventorymanagement.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.inventorymanagement.categories.Category;
import com.inventorymanagement.warehouses.Warehouses;


@RestController
@CrossOrigin("http://localhost:3000")
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
	
	@GetMapping("/all/warehouse/{warehouseId}")
	List<Product> getAllProductsByWarehouseId(@PathVariable Long warehouseId) {
		return service.getAllProductsByWarehouseId(warehouseId);
	}
	
	@GetMapping("/all/warehouse/lowlevel/{warehouseId}/{level}")
	List<Product> getAllLowLevelProductsByWarehouseId(@PathVariable Long warehouseId, @PathVariable Integer level) {
		return service.getAllLowLevelProductsByWarehouseId(warehouseId, level);
	}
	
	@GetMapping("/all/warehouse/highlevel/{warehouseId}/{level}")
	List<Product> getAllHighLevelProductsByWarehouseId(@PathVariable Long warehouseId, @PathVariable Integer level) {
		return service.getAllHighLevelProductsByWarehouseId(warehouseId, level);
	}
	
	@GetMapping("/all/warehouse/getInventory/{warehouseId}")
	List<Product> getAllLowAndHighLevelProductsByWarehouseId(@PathVariable Long warehouseId) {
		return service.getAllLowAndHighLevelProductsByWarehouseId(warehouseId);
	}

	@PostMapping("/all/{categoryId}/{warehouseId}")
	void addNewProduct(@RequestBody Product product, @PathVariable Long categoryId, @PathVariable Long warehouseId) {
		product.setCategory(new Category(categoryId));
		product.setWarehouse(new Warehouses(warehouseId));
		service.addNewProduct(product);
	}

	@PutMapping("/all/{productId}/{categoryId}")
	void updateProduct(@RequestBody Product product, @PathVariable Long categoryId) {
		product.setCategory(new Category(categoryId));
		service.updateProduct(product);
	}
	
	@PutMapping("/all/update/product/{productId}")
	void updateProductDetails(@RequestBody Product product, @PathVariable Long productId) {
//		Optional<Product> productOptional = service.getProductById(productId);
//		Product product = productOptional.get();
//		product.setUnitsInStocks(units);
		service.updateProduct(product);
	}
	
	@PutMapping("/all/update/units/{productId}/{units}")
	void updateProductUnitStock(@PathVariable Long productId, @PathVariable Integer units) {
		Optional<Product> productOptional = service.getProductById(productId);
		Product product = productOptional.get();
		product.setUnitsInStocks(units);
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