package com.inventorymanagement.purchase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.products.Product;
import com.inventorymanagement.products.ProductService;
import com.inventorymanagement.suppliers.Suppliers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1.0/purchase")
public class PurchaseController {
	@Autowired
	PurchaseService service;
	
	@GetMapping("/all")
	List<Purchase> getAllPurchase() {
		return service.getAllPurchase();
	}
	
	@GetMapping("/{purchaseId}")
	List<Purchase> getByProductIdByPurchaseId(@PathVariable Long purchaseId) {
		return service.getByProductIdByPurchaseId(purchaseId);
	}
	@PostMapping("/new/{supplierId}/{productId}")
	public void newPurchase(@RequestBody Purchase purchase, @PathVariable Long supplierId, @PathVariable Long productId ) {
		purchase.setSuppliers(new Suppliers(supplierId));
		purchase.setProduct(new Product(productId));
		service.newPurchase(purchase);
	}
	
	@PutMapping("/new/{supplierId}/{productId}")
	public void update(@RequestBody Purchase purchase, @PathVariable Long supplierId, @PathVariable Long productId ) {
		purchase.setSuppliers(new Suppliers(supplierId));
		purchase.setProduct(new Product(productId));
		service.update(purchase);
	}
	
	@PutMapping("/purchaseid/{purchaseId}")
		public void updateByPurchase(@PathVariable Long purchaseId,@RequestBody Purchase purchase) {
			service.update(purchase);
		
	}
	
	
	@DeleteMapping("{purchaseId}")
	public void deleteByPurchaseId(@PathVariable Long purchaseId) {
		service.deleteByPurchaseId(purchaseId);
		
	}
	

}
