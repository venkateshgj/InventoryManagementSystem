package com.inventorymanagement.warehouses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WarehousesService {
	
	@Autowired
	WarehousesRepository repo;
	
	public Iterable<Warehouses> getAllWarehouses() {
		return repo.findAll();
	}
	
	public void addNewWarehouse(@RequestBody Warehouses warehouse) {
		repo.save(warehouse);
	}
}
