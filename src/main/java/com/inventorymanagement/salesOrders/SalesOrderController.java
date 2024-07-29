package com.inventorymanagement.salesOrders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.products.Product;

@RestController
@RequestMapping("/api/v1.0/salesOrders")
public class SalesOrderController {

	@Autowired
	SalesOrderService service;
	
	@GetMapping("/all")
	Iterable<SalesOrder> getAllSalesOrders() {
		return service.getAllSalesOrders();
	}

	@GetMapping("/all/{id}")
	Optional<SalesOrder> getSalesOrderById(@PathVariable Long id) {
		return service.getSalesOrderById(id);
	}

	@GetMapping("/all/product/{productId}")
	List<SalesOrder> getAllSalesOrdersByProductId(@PathVariable Long productId) {
		return service.getAllSalesOrdersByProductId(productId);
	}

	@PostMapping("/all/{productId}")
	void addNewSalesOrder(@RequestBody SalesOrder salesOrder, @PathVariable Long productId) {
		salesOrder.setProduct(new Product(productId));
		service.addNewSalesOrder(salesOrder);
	}

	@PutMapping("/all/{salesOrderId}/{productId}")
	void updateSalesOrder(@RequestBody SalesOrder salesOrder, @PathVariable Long productId) {
		salesOrder.setProduct(new Product(productId));
		service.updateSalesOrder(salesOrder);
	}

	@DeleteMapping("/all/{id}")
	void deleteASalesOrderById(@PathVariable Long id) {
		service.deleteASalesOrderById(id);
	}
	
	@DeleteMapping("/all/product/{productId}")
	void deleteAllSalesOrderByProductId(@PathVariable Long productId) {
		service.deleteAllSalesOrderByProductId(productId);
	}
}
