package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Discount;
import com.app.pojo.Product;

@Repository
public class DiscountDaoImpl implements DiscountDao {

	@Autowired
	SessionFactory factory;

	@Override
	public Discount saveDiscount(Discount discount) {
		 factory.getCurrentSession().saveOrUpdate(discount);
		 return discount;

	}

	@Override
	public Discount retriveDiscount(Product product) {
		return (Discount) factory.getCurrentSession().createQuery("select d from Discount d where d.product=:pro")
				.setParameter("pro", product);

	}
	// dependency factory

}
