package com.app.dao;

import java.util.List;

import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Feedback;



@Repository
public class FeedbackDaoImpl implements FeedbackDao 
{

@Autowired
SessionFactory factory;
	@Override
	public void givenFeedback(Feedback feedback) 
	{
		factory.getCurrentSession().saveOrUpdate(feedback);
		
	}
	// dependency factory

}
