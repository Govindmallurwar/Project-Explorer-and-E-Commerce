package com.app.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojo.Order;
import com.app.pojo.Product;
import com.app.pojo.User;
import com.app.service.OrderService;
import com.app.service.ProductService;
import com.app.service.UserService;

@Controller 
@RequestMapping("/order") 
public class OrderController {
	
	@Autowired
	ProductService service;
	
	@Autowired
	OrderService service1;
	
	@Autowired
	UserService service2;
	
	@RequestMapping(value = "/orderProductPassThrough",method = RequestMethod.GET)
	public String orderPassThrough(HttpSession hs) 
	{
		User user=(User) hs.getAttribute("user");
		if(user==null)
			return "Login";
		return "Order";
	}
	
	@RequestMapping(value = "/addProduct/{prodId}", method = RequestMethod.GET)
	public String registerProduct(@PathVariable int prodId,RedirectAttributes attr,HttpSession hs) 
	{
		List<Order> ol=(List<Order>) hs.getAttribute("orderList");
		if(ol==null)
		      ol=new LinkedList<Order>();
		
		
		
		Order temp=new Order();
		
			
		temp.setProdId(prodId);
		temp.setProduct(service.searchProductId(prodId));
		temp.setStatus("requested");
		ol.add(temp);
		hs.setAttribute("orderList", ol);
		hs.setAttribute("status","Product added to cart...");
		//System.out.println(temp);
		return "redirect:/product/searchProduct/2";
	}
	
	@RequestMapping(value = "/storeOrder",method = RequestMethod.GET)
	public String storeOrder(HttpSession hs) 
	{
		User user=(User) hs.getAttribute("user");
		List<Order> ol=(List<Order>) hs.getAttribute("orderList");
		for (Order order : ol) {
			order.setUser(user);
			order.setUserId(user.getUserId());
			service1.registerOrder(order);
		}
		hs.removeAttribute("orderList");
		return "redirect:/product/searchProduct/1";
	}
	
	@RequestMapping(value = "/showOrder",method = RequestMethod.GET)
	public String showOrder(HttpSession hs) 
	{
		User user=(User) hs.getAttribute("user");
		if(user==null)
			return "Login";
		
		List<Order> ol=service1.getOrder(user);
		for (Order temp : ol) {
			temp.setProduct(service.searchProductId(temp.getProdId()));
		}
		hs.setAttribute("orderList",ol);
		return "MyOrder";
	}
	

	@RequestMapping(value = "/showOrderVendor/{statusId}", method = RequestMethod.GET)
	public String showOrderVendor(@PathVariable int statusId,HttpSession hs) 
	{
		String status;
		List<Order> temp=new LinkedList<>();
		User user=(User) hs.getAttribute("user");
		
		switch(statusId){
		case 1:status="requested";
		break;
		case 2:status="pending";
		break;
		case 3:status="dispatched";
		break;
		default:status="completed";
		break;
		}
		List<Order> ol=service1.getOrderVendor(user);
		
		for (Order order : ol) {
			if(order.getStatus().equalsIgnoreCase(status)){
				order.setCustomer(service2.getUserId(order.getUserId()));
				order.setProduct(service.searchProductId(order.getProdId()));
				temp.add(order);
				
			}		
		}
		System.out.println(ol);
		hs.setAttribute("statusOrder",temp);
		hs.setAttribute("noOfOrder", temp.size());
		return "Confirm";
	}
	
	@RequestMapping(value = "/changeOrder/{statusId}", method = RequestMethod.GET)
	public String changeOrder(@PathVariable int statusId,@RequestParam("status") String status,HttpSession hs) 
	{
		List<Order> ol=(List<Order>) hs.getAttribute("statusOrder");
		Order temp=null;
		for (Order order : ol) {
			if(order.getOrderId()==statusId){
				temp=order;
				break;
			}
		}
		
		temp.setStatus(status);
		service1.registerOrder(temp);
		return "redirect:/product/searchProduct/1";
	     
	}
}
