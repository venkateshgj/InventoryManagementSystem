package com.inventorymanagement.purchase;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inventorymanagement.salesOrders.SalesOrder;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

	List<Purchase> findByProductProductId(Long productId);
	
	@Query("select o from Purchase o where o.product.id in ( select p.id from Product p where p.warehouse.id= :warehouseId)")
	List<Purchase> getAllPurchaseByWarehouseId(Long warehouseId);

}
