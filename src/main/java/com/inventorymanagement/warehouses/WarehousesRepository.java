package com.inventorymanagement.warehouses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends CrudRepository<Warehouses, Long> {
    Warehouses findByWarehouseIdAndUserNameAndPassword(Long warehouseId, String userName, String password);

	Warehouses findByUserNameAndPassword(String userName, String password);
}
