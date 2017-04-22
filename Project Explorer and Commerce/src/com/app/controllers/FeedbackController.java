package com.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojo.Feedback;
import com.app.pojo.User;
import com.app.service.FeedbackService;
import com.app.service.OrderService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	OrderService service1;

	@Autowired
	FeedbackService service;

	@RequestMapping(value = "/passThroughFeedback/{orderId}", method = RequestMethod.GET)
	public String passThroughFeedback(@PathVariable int orderId, Model map, HttpSession hs) {
		hs.setAttribute("feedbackOrderId", orderId);

		map.addAttribute("feedbackModel", new Feedback());

		return "Feedback";
	}

	@RequestMapping(value = "/processFeedback", method = RequestMethod.POST)
	public String processFeedback(@ModelAttribute("feedbackModel") Feedback feedback, Model map, HttpSession hs) {
		int orderId = (int) hs.getAttribute("feedbackOrderId");
		hs.removeAttribute("feedbackOrderId");
		feedback.setOrder(service1.getOrderById(orderId));
		service.givenFeedback(feedback);
		
		
		return "redirect:/product/searchProduct/1";
	}

}
