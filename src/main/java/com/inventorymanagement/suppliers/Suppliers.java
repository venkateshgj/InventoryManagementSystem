package com.inventorymanagement.suppliers;

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
//@AllArgsConstructor
@NoArgsConstructor
public class Suppliers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	private String supplierName;
	
	@ManyToOne
	Category category;
	
	private String phone;

	public Suppliers(Long supplierId, String supplierName,Long categoryId, String phone) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.category = new Category(categoryId);
		this.phone = phone;
	}

}
