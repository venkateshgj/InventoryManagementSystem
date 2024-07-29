package com.inventorymanagement.suppliers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventorymanagement.products.Product;

@Service
public class SuppliersService {
	
	@Autowired
	SuppliersRepository repo;
	
	public List<Suppliers> getAll() {
		return (List<Suppliers>) repo.findAll();
	}
	
	Optional<Suppliers> getSupplierById(Long id) {
		return repo.findById(id);
	}
	
	public void addSupplier(Suppliers supplier) {
		repo.save(supplier);
	}
	
	public void updateSupplier(Suppliers supplier) {
		repo.save(supplier);
	}
	
	void deleteASupplier(Long id) {
		repo.deleteById(id);
	}
	
	List<Suppliers> getAllSuppliersBycategoryId(Long categoryId) {
		return repo.findByCategoryCategoryId(categoryId);
	}
	
	@Transactional
	void deleteAllSuppliersByCategoryId(Long categoryId) {
		repo.deleteAllSuppliersByCategoryId(categoryId);
	}
}
