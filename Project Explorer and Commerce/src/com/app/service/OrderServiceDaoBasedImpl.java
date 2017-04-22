package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OrderDao;
import com.app.dao.ProductDao;
import com.app.pojo.Order;
import com.app.pojo.User;

@Service("OrderService")
@Transactional
public class OrderServiceDaoBasedImpl implements OrderService {

	
	@Autowired
	OrderDao dao;
	
	@Override
	public Order registerOrder(Order order) {
		return dao.registerOrder(order);
	}

	@Override
	public List<Order> getOrder(User user) {
		return dao.getOrder(user);
	}

	@Override
	public List<Order> getOrderVendor(User user) {
		// TODO Auto-generated method stub
		return dao.getOrderVendor(user);
	}

	@Override
	public Order getOrderById(int orderId) 
	{
		
		return dao.getOrderById(orderId);
	}
	
}
