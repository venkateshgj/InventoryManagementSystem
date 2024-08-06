package com.inventorymanagement.purchase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagement.salesOrders.SalesOrder;

@Service
public class PurchaseService {

	@Autowired
	PurchaseRepository repo;
	
	List<Purchase> getAllPurchase(){
		return (List<Purchase>)(repo.findAll());
	}
	
	List<Purchase> getByProductIdByPurchaseId(long productId){
		return repo.findByProductProductId(productId);
	}
	
	List<Purchase> getAllPurchaseByWarehouseId(Long warehouseId) {
		return repo.getAllPurchaseByWarehouseId(warehouseId);
	}
	
	void newPurchase(Purchase purchase) {
		repo.save(purchase);
	}
	
	void update(Purchase purchase) {
		repo.save(purchase);
	}
	
	void deleteByPurchaseId(Long purchaseId) {
		repo.deleteById(purchaseId);
		
	}
	
	Optional<Purchase> getPurchaseById(Long purchaseId) {
		return repo.findById(purchaseId);
	}
	
	
}
