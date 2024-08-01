package com.inventorymanagement.warehouses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousesService {
	
	@Autowired
	WarehousesRepository repo;
	
	public Iterable<Warehouses> getAllWarehouses() {
		return repo.findAll();
	}
	
	public void addNewWarehouse(Warehouses warehouse) {
		repo.save(warehouse);
	}

	public boolean checkCredentials(Long warehouseId, String userName, String password) {
		Warehouses warehouse=repo.findByWarehouseIdAndUserNameAndPassword(warehouseId, userName, password);
		if(warehouse!=null) return true;
		return false;
	}

	public Long getWarehouseIdUsingUserNameAndPassword(String userName, String password) {
		return repo.findByUserNameAndPassword(userName,password).getWarehouseId();
	}
	
	
	
	
	
	
}
