package com.inventorymanagement.warehouses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.categories.Category;



@RestController
@RequestMapping("/api/v1.0/warehouses")
public class WarehousesController {
	
	@Autowired
	WarehousesService service;
	
	@GetMapping("/all")
	public Iterable<Warehouses> getAllWarehouses() {
		return service.getAllWarehouses();
	}
	
	@PostMapping("/all")
	public void addNewWarehouse(@RequestBody Warehouses warehouse) {
		service.addNewWarehouse(warehouse);
	}
}
