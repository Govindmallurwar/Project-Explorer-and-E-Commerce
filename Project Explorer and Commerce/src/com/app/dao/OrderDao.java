package com.app.dao;

import java.util.List;

import com.app.pojo.Order;
import com.app.pojo.Product;
import com.app.pojo.SearchProduct;
import com.app.pojo.User;

public interface OrderDao {
	
	Order registerOrder(Order order);
	List<Order> getOrder(User user);
	List<Order> getOrderVendor(User user);
	
	Order getOrderById(int orderId);
	
}
