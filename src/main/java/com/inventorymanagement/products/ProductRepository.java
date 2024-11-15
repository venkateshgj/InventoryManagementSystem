package com.inventorymanagement.products;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByCategoryCategoryId(Long categoryId);
	
	@Modifying
	@Transactional
	@Query("delete from Product p where p.category.id = :categoryId")
	void deleteAllProductsByCategoryId(Long categoryId);

}
