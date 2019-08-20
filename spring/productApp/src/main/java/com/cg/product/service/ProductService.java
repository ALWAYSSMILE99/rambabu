package com.cg.product.service;

import java.util.List;

import com.cg.product.bean.Product;

public interface ProductService {

		List<Product> getAllProducts();
		Product getProductById(int id);
		void addProduct(Product prod);
		void deleteProduct(int id);
		void updateProduct(Product prod);
		List<Product> getProductByCategory(String category);
		Product updatePrice(int id,double price);
		public boolean doValidation(String cate, int qty);
		List<Product> getProductByPrice(double minPrice,double maxPrice );
}
