package com.inventorymanagement.warehouses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Warehouses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warehouseId;
	private String warehouseName;
	
	public Warehouses(Long warehouseId) {
		this.warehouseId=warehouseId;
	}
}
