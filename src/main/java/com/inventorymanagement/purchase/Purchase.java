package com.inventorymanagement.purchase;

import java.sql.Timestamp;

import com.inventorymanagement.products.Product;
import com.inventorymanagement.supplier.Suppliers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long purchaseId;
	
	private long quantity;
	
	private Timestamp date;
	
	@ManyToOne
	private Suppliers suppliers;
	
	@ManyToOne
	private Product product;

		public Purchase(long purchaseId, long quantity, Timestamp date, long supplierId, long  productId) {
		super();
		this.purchaseId = purchaseId;
		this.quantity = quantity;
		this.date = date;
		this.suppliers = new Suppliers(supplierId);
		this.product = new Product(productId);
	}

	
	
	
	

}
