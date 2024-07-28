package com.inventorymanagement.products;

import com.inventorymanagement.categories.Category;

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
	private double unitPrice;
	private int unitsInStocks;
	
	@ManyToOne
	private Category category;

	public Product(Long productId, String productName, String description, double unitPrice, int unitsInStocks,
			Long categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.unitsInStocks = unitsInStocks;
		this.category = new Category(categoryId);
	}
	
}
