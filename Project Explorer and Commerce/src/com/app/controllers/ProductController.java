package com.app.controllers;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Discount;
import com.app.pojo.Order;
import com.app.pojo.Product;
import com.app.pojo.SearchProduct;
import com.app.pojo.User;
import com.app.service.DiscountService;
import com.app.service.OrderService;
import com.app.service.ProductService;
import com.app.service.UserService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller 
@RequestMapping("/product") 
public class ProductController 
{
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService service;
	
	@Autowired
	OrderService serviceOrder;
	
	@Autowired
	DiscountService service1;
	
	@RequestMapping(value = "/registerProductPassThrough",method = RequestMethod.GET)
	public String productPassThrough(Model map) 
	{
		map.addAttribute("productModel", new Product());
		return "Product";
	}
	
	@RequestMapping(value = "/registerProduct",method = RequestMethod.POST)
	public String registerProduct(@Valid @ModelAttribute("productModel") Product product,BindingResult res,Model map,HttpSession hs) 
	{
		User user=(User) hs.getAttribute("user");
		
		Discount discount=new Discount();
		discount.setUser_Id(user.getUserId());
		discount.setVenderDiscount(product.getProdDiscount());
		discount=service1.saveDiscount(discount);
		
		product.setUser(user);
		product.setDiscount(discount);
		Product temp=service.registerProduct(product);
		
		discount.setProduct(temp);
		service1.saveDiscount(discount);
		
		hs.setAttribute("productFileUpload",temp);
		return "FileUpload";
	}
	
	
	@RequestMapping(value = "/registerProduct1",method = RequestMethod.POST)
	public String registerProduct1(@Valid @ModelAttribute("productModel") Product product,BindingResult res,Model map,HttpSession hs) 
	{
		User user=(User) hs.getAttribute("user");
        Product temp=(Product) hs.getAttribute("updateProduct");
		
		Discount discount=temp.getDiscount();
		System.out.println(product);
		discount.setVenderDiscount(product.getProdDiscount());
		discount=service1.saveDiscount(discount);
		
		product.setUser(user);
		product.setDiscount(discount);
		service.registerProduct(product);
		
		return "redirect:/product/searchProduct/1";
	}
	
	
	
	  @RequestMapping(value="/upload", method=RequestMethod.POST)
	    public String handleFileUpload(
	            @RequestParam("file") MultipartFile file,Model map,HttpSession hs,ServletRequest rs){
	        if (!file.isEmpty()) {
	            try {
	            	
	                byte[] bytes = file.getBytes();
	                Product temp=(Product) hs.getAttribute("productFileUpload");
	                String fileName=hs.getServletContext().getRealPath("/images/"+temp.getProdId()+".jpg");
	                
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(new File(fileName)));
	                stream.write(bytes);
	                stream.close();
	                
	                temp.setImageAddr(fileName);
	                System.out.println("detached pojo"+temp);
	                service.registerProduct(temp);
	                hs.removeAttribute("productFileUpload");
	                
	                System.out.println("file upload successfully");
	                return "redirect:/product/searchProduct/1"; //like vendor
	            } catch (Exception e) {
	            	System.out.println(e.getMessage());
	            	
	            map.addAttribute("errorInFileUpload","file Upload Fail...");
	              return "FileUpload";
	            }
	        } else {
	        	/*System.out.println("file upload failed file is empty");
	        	 */
	        	map.addAttribute("errorInFileUpload","please select file....");
	            return "FileUpload";
	        }
	    }
	  
	  @RequestMapping(value = "/searchProduct/{searchId}")
		public String searchProduct(@Valid @ModelAttribute("searchModel") SearchProduct sp,@PathVariable int searchId,BindingResult res,HttpSession hs,Model map) throws Exception 
		{
		    System.out.println("Searching id"+searchId);
		    System.out.println(sp);
		    
		    switch(searchId)
		    {
		    	case 1:  sp=new SearchProduct();
		    			sp.setMaxPrice(10000.00);
		    			sp.setKeyword("");
		    			sp.setCategory("");  
		    			hs.setAttribute("sp",sp);
		    			break;
		    	case 2: sp=(SearchProduct) hs.getAttribute("sp");
		    	        break;
		    	case 3:hs.setAttribute("sp",sp);
		    		    break;
		    
		    }
		    
		    
		    
		  
		    List<Product> temp=service.searchProduct(sp);
		    List<Product> temp1=new LinkedList<>();
		    List<Product> temp2=new LinkedList<>();
		    List<Product> temp3=new LinkedList<>();
		    System.out.println(temp);
		    
			  for (Product p: temp) 
			  {
				 
				  if(p.getImageAddr()==null)
				  {
				  continue;
				  }
				  
				  File file= new File(p.getImageAddr());
				  FileInputStream fis=new FileInputStream(file);
				  ByteArrayOutputStream bos=new ByteArrayOutputStream();
				  int b;
				  byte[] buffer = new byte[1024];
				  while((b=fis.read(buffer))!=-1){
				     bos.write(buffer,0,b);
				  }
				  byte[] fileBytes=bos.toByteArray();
				  fis.close();
				  bos.close();


				  byte[] encoded=Base64.encodeBase64(fileBytes);
				  String encodedString = new String(encoded);
				  p.setImageAddr(encodedString);
			  }
		    System.out.println(temp.size());
		    
		    User user=(User) hs.getAttribute("user");
		    if((user!=null)&&(user.getCategory().equalsIgnoreCase("Vendor")))
		    {
			    for (int i=0;i<temp.size();i++) {
					Product t1=temp.get(i);
					if(t1.getUser().getUserId()!=user.getUserId()){
						temp.remove(i);
						i--;
					}
				}
		    }
		    
		    
		   
			for(int i=0;i<temp.size()&&i<4;i++)
			{
				temp1.add(temp.get(i));
				System.out.println("add in temp1"+i);
			}
			
			if(temp.size()>4)
			{
				for(int i=4;i<temp.size()&&i<8;i++)
				{
					temp2.add(temp.get(i));
					System.out.println("add in temp2");
				}
			}
			
			if(temp.size()>8)
			{
				for(int i=8;i<temp.size()&&i<12;i++)
				{
					temp3.add(temp.get(i));
					System.out.println("add in temp3");
				}
			}
			
			
			map.addAttribute("searchResult1",temp1);
			map.addAttribute("searchResult2",temp2);
			map.addAttribute("searchResult3",temp3);
			 
			 if((user!=null)&&(user.getCategory().equalsIgnoreCase("Vendor")))
			    {
				 
				 List<Order> ol=serviceOrder.getOrderVendor(user);
				 List<Order> tempRequest=new LinkedList<>();
				 List<Order> tempPending=new LinkedList<>();
				 List<Order> tempDispatched=new LinkedList<>();
				 List<Order> tempCompleted=new LinkedList<>();
				 
					for (Order order : ol) 
					{
						if(order.getStatus().equalsIgnoreCase("requested"))
							tempRequest.add(order);
						if(order.getStatus().equalsIgnoreCase("pending"))
							tempPending.add(order);
						if(order.getStatus().equalsIgnoreCase("dispatched"))
							tempDispatched.add(order);
						if(order.getStatus().equalsIgnoreCase("completed"))
							tempCompleted.add(order);
					}
					
					hs.setAttribute("countNoOfRequest",tempRequest.size());
					hs.setAttribute("countNoOfPending",tempPending.size());
					hs.setAttribute("countNoOfDispatched",tempDispatched.size());
					hs.setAttribute("countNoOfCompleted",tempCompleted.size());
					
				   return "Vendor";
			    }
			return "home";
		}
	  
	 
	  @RequestMapping(value = "/removeOrder/{prodId}",method = RequestMethod.GET)
		public String removeOrder(@PathVariable int prodId,Model map) 
		{
		  Product temp=service.searchProductId(prodId);
		  temp.setFlag(1);
		  service.registerProduct(temp);	
		  return "redirect:/product/searchProduct/1";
		  
		}
	  
	  @RequestMapping(value = "/passThroughUpdateProduct/{prodId}", method = RequestMethod.GET)
		public String PassThroughUpdateProduct(@PathVariable int prodId,Model map,HttpSession hs) 
		{
			Product temp=service.searchProductId(prodId);
			temp.setProdDiscount(temp.getDiscount().getVenderDiscount());
			map.addAttribute("productModel",temp);
			hs.setAttribute("updateProduct",temp);
			return "UpdateProduct";
		}
	  
	  
}
