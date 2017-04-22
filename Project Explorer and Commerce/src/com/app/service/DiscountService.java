package com.app.service;

import java.util.List;

import com.app.pojo.Discount;
import com.app.pojo.Product;

public interface DiscountService {
	Discount saveDiscount(Discount discount);

	Discount retriveDiscount(Product product);

}
