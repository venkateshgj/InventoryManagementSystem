package com.inventorymanagement.products;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.inventorymanagement.warehouses.Warehouses;



@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByCategoryCategoryId(Long categoryId);
	
	@Modifying
	@Transactional
	@Query("delete from Product p where p.category.id = :categoryId")
	void deleteAllProductsByCategoryId(Long categoryId);
	
	@Query("SELECT p FROM Product p WHERE p.warehouse.id = :warehouseId AND p.unitsInStocks <= :level")
	List<Product> getAllLowLevelProductsByWarehouseId(Long warehouseId, Integer level);

	List<Product> findByWarehouseWarehouseId(Long warehouseId);
	
	@Query("SELECT p FROM Product p WHERE p.warehouse.id = :warehouseId AND p.unitsInStocks >= :level")
	List<Product> getAllHighLevelProductsByWarehouseId(Long warehouseId, Integer level);
	
	@Query("SELECT p FROM Product p WHERE p.warehouse.id = :warehouseId AND (p.unitsInStocks < 501 OR p.unitsInStocks > 2499)")
	List<Product> getAllLowAndHighLevelProductsByWarehouseId(Long warehouseId);


}