package com.cg.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.bean.Product;
import com.cg.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	//read all
	@RequestMapping("/api/products/")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	//by id
	@RequestMapping("/api/products/{id}")
	public Product getProductById(int id)
	{
		return productService.getProductById(id);
	}
	
	
	//add 
	@RequestMapping(value="/api/products/",method=RequestMethod.POST)
	public ResponseEntity<String> addProduct(@RequestBody Product prod)
	{
		String cate = prod.getCategory();
        int qty = prod.getQuantity();
        boolean check = productService.doValidation(cate,qty);
        if(check==false) {
            return new ResponseEntity<String>("Category can be tv, laptop and mobile and quantity must be greater than 0.", HttpStatus.OK);
        }
        else {
		productService.addProduct(prod);
		return new ResponseEntity<String>("Data successfully added",HttpStatus.OK);
	}
	}
	
	//delete
	@RequestMapping(value="/api/products/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Data with" +id+" deleted",HttpStatus.OK);
	}
	
	
	//update
		@RequestMapping(value="/api/products/{id}" ,method=RequestMethod.PUT)
		public ResponseEntity<String> updateProduct(@RequestBody Product prod)
		{
			 productService.updateProduct(prod);
			 return new ResponseEntity<String>("Data updated",HttpStatus.OK); 
		}
		
	
	//category
	@RequestMapping("/api/products/category")
	public List<Product> getProductByCategory(@RequestParam String category)
		{
			return productService.getProductByCategory(category);
		}
	
	
	@RequestMapping("/api/products/price")
    public List<Product> getProductByPrice(@RequestParam double minPrice,@RequestParam double maxPrice){
    return productService.getProductByPrice(minPrice,maxPrice);
	
	
	
	}
}
