package com.inventorymanagement.products;

import com.inventorymanagement.categories.Category;
import com.inventorymanagement.warehouses.Warehouses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String description;
	private Double unitPrice;
	private Integer unitsInStocks;
	
	@ManyToOne
	private Warehouses warehouse;
	
	@ManyToOne
	private Category category;

	public Product(Long productId, String productName, String description, Double unitPrice, Integer unitsInStocks,
			Long warehouseId, Long categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.unitsInStocks = unitsInStocks;
		this.warehouse = new Warehouses(warehouseId);
		this.category = new Category(categoryId);
	}

	public Product(Long productId) {
		this.productId=productId;
	}
	
}
