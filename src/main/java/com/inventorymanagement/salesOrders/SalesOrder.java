package com.inventorymanagement.salesOrders;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.inventorymanagement.products.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SalesOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long salesOrderId;
	
	private Integer quantity;
	
	@CreationTimestamp
	@Column(nullable=false, updatable=false)
	private Timestamp orderDate;
	
	@ManyToOne
	private Product product;

	public SalesOrder(Long salesOrderId, Integer quantity,Timestamp orderDate, Long productId) {
		this.salesOrderId = salesOrderId;
		this.quantity = quantity;
		this.orderDate=orderDate;
		this.product = new Product(productId);
	}
	
	
	
}
