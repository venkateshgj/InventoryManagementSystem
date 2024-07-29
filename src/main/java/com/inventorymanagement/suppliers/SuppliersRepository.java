package com.inventorymanagement.suppliers;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventorymanagement.products.Product;

@Repository
public interface SuppliersRepository extends CrudRepository<Suppliers, Long>{
	List<Suppliers> findByCategoryCategoryId(Long categoryId);
	
	@Modifying
	@Transactional
	@Query("delete from Suppliers p where p.category.id = :categoryId")
	void deleteAllSuppliersByCategoryId(Long categoryId);
}
