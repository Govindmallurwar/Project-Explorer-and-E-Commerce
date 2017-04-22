package com.app.service;

import java.util.List;

import com.app.pojo.Product;
import com.app.pojo.SearchProduct;


public interface ProductService 
{
	Product registerProduct(Product product);
	List<Product> searchProduct(SearchProduct sp);
	Product searchProductId(int id);
	void removeProductById(Product product);
}
