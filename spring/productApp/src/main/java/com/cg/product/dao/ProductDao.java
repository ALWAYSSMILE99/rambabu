package com.cg.product.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.product.bean.Product;
@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	@Query("from Product where category=:pro")
	List<Product> getProductByCategory(@Param("pro")String category);
	
	@Query("from Product where price between :minPrice and :maxPrice")
	List<Product> getProductByPrice(@Param("minPrice")double minPrice, @Param("maxPrice")double maxPrice);
	}
