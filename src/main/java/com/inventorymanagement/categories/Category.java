package com.inventorymanagement.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    @ElementCollection
    @CollectionTable(
        name = "category_products", 
        joinColumns = @JoinColumn(name = "category_id")
    )
    @MapKeyColumn(name = "product_name")
    @Column(name = "product_description")
    private Map<String, String> products = new HashMap<>();
    
    
    
    public Category(Long categoryId) {
        this.categoryId = categoryId;
    }
}


