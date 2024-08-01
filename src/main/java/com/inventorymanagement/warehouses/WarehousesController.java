package com.inventorymanagement.warehouses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
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
	
	@GetMapping("/check-credentials/{warehouseId}/{userName}/{password}")
	public boolean checkCredentials(
			@PathVariable Long warehouseId, 
			@PathVariable String userName, 
			@PathVariable String password) {
		return service.checkCredentials(warehouseId, userName, password);
	}
	
	@GetMapping("/check-credentials/{userName}/{password}")
	public Long getWarehouseIdUsingUserNameAndPassword(
			@PathVariable String userName, 
			@PathVariable String password) {
		return service.getWarehouseIdUsingUserNameAndPassword( userName, password);
	}
}
