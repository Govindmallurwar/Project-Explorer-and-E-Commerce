package com.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojo.SearchProduct;
import com.app.pojo.User;

@Controller 
@RequestMapping("/utils") 
public class Utils 
{
	@RequestMapping(value = "/contactus",method = RequestMethod.GET)
	public String contactUsPassThrough() 
	{
		return "contactUs";
	}
	
@RequestMapping(value="/goToHome")
public String home1()
{
	return "redirect:/product/searchProduct/1";
}
	
	
	
	@RequestMapping(value = "/myaccount",method = RequestMethod.GET)
	public String myprofile(HttpSession hs,Model map) 
	{
		
		User user=(User) hs.getAttribute("user");
		if(user==null)
		{
			return "Login";
		}
		
		map.addAttribute("updateModel",user);
		return "myAccount";
	}
	
	 @RequestMapping(value = "/searchCategory/{catId}")
		public String searchProduct(@PathVariable int catId,HttpSession hs) throws Exception 
		{
		  SearchProduct sp=new SearchProduct();
		  sp.setMaxPrice(10000.00);
		  sp.setKeyword("");
		  
		  switch(catId){
		    case 1:sp.setCategory("Information Technology");
		    	break;
		    case 2:sp.setCategory("Electronics");
	    	break;
		    case 3:sp.setCategory("Mechanical");
	    	break;
		    case 4:sp.setCategory("Civil");
	    	break;
		    case 5:sp.setCategory("Instrumentation");
	    	break;
		    default:sp.setCategory("Electrical");
	    	break;
		  
		  }
		  
		  hs.setAttribute("sp",sp);
		  return "redirect:/product/searchProduct/2";
		 
		}
}
