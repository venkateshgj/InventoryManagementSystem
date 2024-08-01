package com.inventorymanagement.warehouses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warehouseId;
	private String warehouseName;
	private String userName;
	private String password;
	
	public Warehouses(Long warehouseId) {
		this.warehouseId=warehouseId;
	}
}
