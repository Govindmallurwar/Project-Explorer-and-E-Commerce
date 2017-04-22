package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.pojo.Product;
import com.app.pojo.SearchProduct;

@Service("ProductService")
@Transactional
public class ProductServiceDaoBasedImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Override
	public Product registerProduct(Product product) 
	{
		return dao.registerProduct(product);
	}
	
	@Override
	public List<Product> searchProduct(SearchProduct sp) {
		
		return dao.searchProduct(sp);
	}

	@Override
	public Product searchProductId(int id) {
		
		return dao.searchProductId(id);
	}

	@Override
	public void removeProductById(Product product) 
	{
		dao.removeProductById(product);
		
	}
	
}
