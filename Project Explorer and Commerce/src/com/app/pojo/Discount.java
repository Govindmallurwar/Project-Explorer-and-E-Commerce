package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DISCOUNTS database table.
 * 
 */
@Entity
@Table(name="DISCOUNTS")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d")
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DISCOUNT_ID")
	@GeneratedValue
	private int discountId;

	@Column(name="ADMIN_DISCOUNT",scale=10,precision=2)
	private double adminDiscount;

	@Column(name="USER_ID")
	private int user_Id;

	@Column(name="VENDER_DISCOUNT",scale=10,precision=2)
	private double venderDiscount;

	//bi-directional one-to-one association to Product
	@OneToOne
	@JoinColumn(name="PROD_ID")
	private Product product;

	public Discount() {
	}

	public long getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public double getAdminDiscount() {
		return this.adminDiscount;
	}

	public void setAdminDiscount(double adminDiscount) {
		this.adminDiscount = adminDiscount;
	}

	public int getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public double getVenderDiscount() {
		return this.venderDiscount;
	}

	public void setVenderDiscount(double venderDiscount) {
		this.venderDiscount = venderDiscount;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}