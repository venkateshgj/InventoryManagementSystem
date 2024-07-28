package com.inventorymanagement.products;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagement.categories.Category;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
//	@Query("select * from Product where category_category_id=:categoryId")
//	 List<Category> getByCategoryCategoryId(Long categoryId);

}
