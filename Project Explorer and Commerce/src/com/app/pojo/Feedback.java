package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FEEDBACKS database table.
 * 
 */
@Entity
@Table(name="FEEDBACKS")
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FEEDBACK_ID")
	@GeneratedValue
	private long feedbackId;
	@Column(name="COMMENTS",length=50)
	private String comments;
	
	@Column(name="FLAG",scale=1)
	private int flag;
	
	@Column(name="SCORE",scale=5)
	private int score;

	//bi-directional one-to-one association to Order
	@OneToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;

	public Feedback() {
	}

	public long getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getFlag() {
		return this.flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}