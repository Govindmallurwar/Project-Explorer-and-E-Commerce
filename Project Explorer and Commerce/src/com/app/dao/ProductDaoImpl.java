package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Product;
import com.app.pojo.SearchProduct;



@Repository
public class ProductDaoImpl implements ProductDao 
{

	@Autowired
	public SessionFactory factory;
	
	@Override
	public Product registerProduct(Product product) 
	{
		product.setCurrentDate(new Date());
		
		factory.getCurrentSession().saveOrUpdate(product);
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchProduct(SearchProduct sp) {
		String key="%"+sp.getKeyword().toLowerCase()+"%";
		
		String category="%"+sp.getCategory()+"%";
		return factory.getCurrentSession().createQuery("Select p from Product p where (lower(p.prodName) LIKE :key) and (p.prodPrice between :min and :max) and (p.category LIKE :category) and (p.flag=0)").setParameter("min",sp.getMinPrice()).setParameter("category",category).setParameter("key",key).setParameter("max",sp.getMaxPrice()).list();
		
	}

	@Override
	public Product searchProductId(int id) {
		Product temp=(Product) factory.getCurrentSession().get(Product.class,id);
		return temp;
	}

	@Override
	public void removeProductById(Product product) 
	{
		factory.getCurrentSession().delete(product);
		
	}


}
