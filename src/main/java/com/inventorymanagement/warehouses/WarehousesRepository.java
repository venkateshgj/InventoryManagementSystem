package com.inventorymanagement.warehouses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

public interface WarehousesRepository extends CrudRepository<Warehouses, Long>{
	
	
}
