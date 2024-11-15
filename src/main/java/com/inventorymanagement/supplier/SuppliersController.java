package com.inventorymanagement.supplier;

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
import com.inventorymanagement.products.Product;

@RestController
@RequestMapping("/api/v1.0/suppliers")
public class SuppliersController {
	
	@Autowired
	SuppliersService service;
	
	@GetMapping("/all")
	public List<Suppliers> fetchSuppliers() {
		return  service.getAll();
	}
	
	@GetMapping("/all/{id}")
	Optional<Suppliers> getSupplierById(@PathVariable Long id) {
		return service.getSupplierById(id);
	}
	
	@PostMapping("/all/add")
	public void addSupplier(@RequestBody Suppliers supplier) {
		service.addSupplier(supplier);
	}
	
	@PutMapping("/all/update")
	public void updateSupplier(@RequestBody Suppliers supplier) {
		service.updateSupplier(supplier);
	}
	
	@DeleteMapping("/all/{id}")
    void deleteASupplier(@PathVariable Long id){
        service.deleteASupplier(id);
    }

	@GetMapping("/all/category/{categoryId}")
	List<Suppliers> getAllSuppliersBycategoryId(@PathVariable Long categoryId) {
		return service.getAllSuppliersBycategoryId(categoryId);
	}

	@PostMapping("/all/{categoryId}")
	void addSupplier(@RequestBody Suppliers supplier, @PathVariable Long categoryId) {
		supplier.setCategory(new Category(categoryId));
		service.addSupplier(supplier);
	}

	@PutMapping("/all/{supplierId}/{categoryId}")
	void updateSupplier(@RequestBody Suppliers supplier, @PathVariable Long categoryId) {
		supplier.setCategory(new Category(categoryId));
		service.updateSupplier(supplier);
	}
	
	@DeleteMapping("/all/category/{categoryId}")
	void deleteAllSuppliersByCategoryId(@PathVariable Long categoryId) {
		service.deleteAllSuppliersByCategoryId(categoryId);
	}
}
