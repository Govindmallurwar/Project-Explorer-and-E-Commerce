package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="PROD_ID",scale=10)
	private int prodId;

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", description=" + description + ", flag=" + flag + ", imageAddr="
				+ imageAddr + ", prodName=" + prodName + ", category=" + category + ", prodPrice=" + prodPrice
				+ ", technology=" + technology + ", user=" + user + ", discount=" + discount + "]";
	}
	@Column(name="UPLOADDATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	@Column(name="DESCRIPTION",length=50)
	private String description;

	@Column(name="FLAGS",scale=1)
	private int flag;

	@Column(name="IMAGE_ADDR",length=200)
	private String imageAddr;

	@Column(name="PROD_NAME",length=50)
	private String prodName;

	@Column(name="CATEGORY",length=50)
	private String category;

	@Transient
	private double prodDiscount;
	
	
	public double getProdDiscount() {
		return prodDiscount;
	}

	public void setProdDiscount(double prodDiscount) {
		this.prodDiscount = prodDiscount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="PROD_PRICE",scale=10,precision=2)
	private double prodPrice;

	@Column(name="TECHNOLOGY",length=50)
	private String technology;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional one-to-one association to Discount
	@OneToOne(mappedBy="product")
	private Discount discount;

	public Product() {
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlag() {
		return this.flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getImageAddr() {
		return this.imageAddr;
	}

	public void setImageAddr(String imageAddr) {
		this.imageAddr = imageAddr;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


}