package com.cg.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.bean.Product;
import com.cg.product.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	@Override
	public List<Product> getAllProducts() {
		
		return productDao.findAll();
	}
	
	@Override
	public Product getProductById(int id) {
	
		return productDao.findById(id).get();
	}

	@Override
	public void addProduct(Product prod) {
		
		productDao.save(prod);
	}

	@Override
	public void deleteProduct(int id) {
		
		productDao.deleteById(id);
	}

	@Override
	public void updateProduct(Product prod) {
		productDao.save(prod);
		
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		
		return productDao.getProductByCategory(category);
	}

	@Override
	public Product updatePrice(int id, double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doValidation(String cate, int qty) {
		
		if((cate.equals("phone") ||cate.equals("tv") ||cate.equals("laptop")) && qty>0)
            return true;
        else
		return false;
	}

	
    @Override
    public List<Product> getProductByPrice(double minPrice, double maxPrice) {
        // TODO Auto-generated method stub
        return productDao.getProductByPrice(minPrice, maxPrice);
    }



	
	

}
