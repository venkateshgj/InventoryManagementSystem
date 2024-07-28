package com.inventorymanagement.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier/v1.0")
public class SuppliersController {
	
	@Autowired
	SuppliersService service;
	
	@GetMapping("/suppliers")
	public List<Suppliers> fetchSuppliers() {
		return  service.getAll();
	}
	
	@PostMapping("/suppliers/add")
	public void addSupplier(@RequestBody Suppliers supplier) {
		service.addSupplier(supplier);
	}
	
	@PutMapping("/suppliers/update")
	public void updateSupplier(@RequestBody Suppliers supplier) {
		service.updateSupplier(supplier);
	}
}
