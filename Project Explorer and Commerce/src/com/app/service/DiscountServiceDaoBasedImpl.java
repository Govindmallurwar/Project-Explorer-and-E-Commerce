package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DiscountDao;
import com.app.pojo.Discount;
import com.app.pojo.Product;

@Service("DiscountService")
@Transactional
public class DiscountServiceDaoBasedImpl implements DiscountService {

	@Autowired
	DiscountDao dao;
	
	@Override
	public Discount saveDiscount(Discount discount) {
		dao.saveDiscount(discount);
		return discount;
		
	}

	@Override
	public Discount retriveDiscount(Product product) 
	{
		return dao.retriveDiscount(product);
		
	}
	
}
