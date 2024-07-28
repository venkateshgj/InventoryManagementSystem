package com.inventorymanagement.supplier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliersService {
	
	@Autowired
	SuppliersRepository repo;
	
	public List<Suppliers> getAll() {
		return (List<Suppliers>) repo.findAll();
	}
	
	public void addSupplier(Suppliers supplier) {
		repo.save(supplier);
	}
	
	public void updateSupplier(Suppliers supplier) {
		repo.save(supplier);
	}
}
