package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FeedbackDao;
import com.app.pojo.Feedback;

@Service("FeedbackService")
@Transactional
public class FeedbackServiceDaoBasedImpl implements FeedbackService 
{
	@Autowired
	FeedbackDao dao;
	@Override
	public void givenFeedback(Feedback feedback) 
	{
		dao.givenFeedback(feedback);
		
	}
	
}
