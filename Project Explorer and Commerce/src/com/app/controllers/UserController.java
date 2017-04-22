package com.app.controllers;

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

import com.app.pojo.Product;
import com.app.pojo.User;
import com.app.service.UserService;



@Controller 
@RequestMapping("/user") 
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUserPassThrough(Model map) {
		map.addAttribute("userModel", new User());
		return "SignUp1";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("userModel") User c, BindingResult res, Model map) 
	{
		
		System.out.println("in user controller ");
		if(res.hasFieldErrors())
		{
			map.addAttribute("userModel",c);
			System.out.println("P.L errors in register");
			return "SignUp1";
		}
		User temp=null;
		try{
		temp=service.registerUser(c);}
		catch(Exception e){
			System.out.println(e.getMessage());
			map.addAttribute("msgToSignUp","Username already exists..");
			return "SignUp1";
		}
		System.out.println("In user register"+temp);
		map.addAttribute("msg","Register Successfully....<br>&nbsp;&nbsp;&nbsp;&nbsp;Your Registration Id:"+temp.getUserId());
		return "Login";
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public String validateUserPassThrough(Model map) {
		map.addAttribute("userModel", new User());
		System.out.println("pass through validate");
		return "Login";
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateUser(@ModelAttribute("userModel") User c, BindingResult res, Model map,HttpSession hs) {
		User temp=service.validateUser(c);
		if(temp==null)
		{
			map.addAttribute("msg","Invalid username or password...");
			return "Login";
		}
		hs.setAttribute("user",temp);
		//if(temp.getCategory().equalsIgnoreCase("Customer"))
			return "redirect:/product/searchProduct/1";
		//return "Vendor";
		
	}
	
	@RequestMapping(value = "/invalidate", method = RequestMethod.GET)
	public String invalidateUserPassThrough(HttpSession hs) {
		hs.invalidate();
		return "redirect:/product/searchProduct/1";
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPasswordPassThrough() {
		
		return "ForgetPassword";
	}	
	
	
}
