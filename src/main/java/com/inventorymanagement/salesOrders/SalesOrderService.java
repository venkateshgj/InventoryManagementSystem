package com.inventorymanagement.salesOrders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventorymanagement.products.Product;

@Service
public class SalesOrderService {

	@Autowired
	SalesOrderRepository repo;

	Iterable<SalesOrder> getAllSalesOrders() {
		return repo.findAll();
	}
	
	Optional<SalesOrder> getSalesOrderById(Long id) {
		return repo.findById(id);
	}
	
	List<SalesOrder> getAllSalesOrdersByProductId(Long productId) {
		return repo.findByProductProductId(productId);
	}

	void addNewSalesOrder(SalesOrder salesOrder) {
		repo.save(salesOrder);
	}

	void updateSalesOrder(SalesOrder salesOrder) {
		repo.save(salesOrder);
	}

	void deleteASalesOrderById(Long id) {
		repo.deleteById(id);
	}

	@Transactional
	void deleteAllSalesOrderByProductId(Long productId) {
		repo.deleteAllSalesOrderByProductId(productId);
	}


}
