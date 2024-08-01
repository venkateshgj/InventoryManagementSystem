package com.inventorymanagement.categories;

import java.util.Map;

public class CategoryRequest {

	private String name;
	private Map<String, String> products;

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProducts() {
		return products;
	}

	public void setProducts(Map<String, String> products) {
		this.products = products;
	}
}
