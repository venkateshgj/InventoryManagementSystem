package com.inventorymanagement.salesOrders;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {

	List<SalesOrder> findByProductProductId(Long productId);

	@Modifying
	@Transactional
	@Query("delete from SalesOrder s where s.product.id=:productId")
	void deleteAllSalesOrderByProductId(Long productId);

}
