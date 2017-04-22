package com.app.dao;

import com.app.pojo.Discount;
import com.app.pojo.Product;

public interface DiscountDao 
{
	Discount saveDiscount(Discount discount);
	Discount retriveDiscount(Product product);
}
