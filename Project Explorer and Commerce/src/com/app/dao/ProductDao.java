package com.app.dao;

import java.util.List;

import com.app.pojo.Product;
import com.app.pojo.SearchProduct;
import com.app.pojo.User;

public interface ProductDao {
	
	Product registerProduct(Product product);
	List<Product> searchProduct(SearchProduct sp);
	Product searchProductId(int id);
	void removeProductById(Product product);
}
