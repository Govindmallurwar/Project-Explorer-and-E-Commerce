package com.app.service;

import java.util.List;

import com.app.pojo.Order;
import com.app.pojo.User;


public interface OrderService {

	Order registerOrder(Order order);
	List<Order> getOrder(User user);
	List<Order> getOrderVendor(User user);
	Order getOrderById(int orderId);
}
