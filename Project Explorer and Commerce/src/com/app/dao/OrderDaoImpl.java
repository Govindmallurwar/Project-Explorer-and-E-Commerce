package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Order;
import com.app.pojo.User;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	public SessionFactory factory;

	@Override
	public Order registerOrder(Order order) {
		factory.getCurrentSession().saveOrUpdate(order);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrder(User user) {
		return factory.getCurrentSession().createQuery("Select o from Order o where o.user=:ui")
				.setParameter("ui", user).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderVendor(User user) {

		return (List<Order>) factory.getCurrentSession()
				.createQuery(
						"Select o from Order o where o.prodId IN (Select p.prodId from Product p where p.user=:us)")
				.setParameter("us", user).list();
	}

	@Override
	public Order getOrderById(int orderId) {
		return (Order) factory.getCurrentSession().get(Order.class, orderId);

	}

}
