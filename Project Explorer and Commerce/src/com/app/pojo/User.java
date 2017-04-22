package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



import java.security.MessageDigest;
import java.util.List;

@Entity
@Table(name = "USERS1", uniqueConstraints = @UniqueConstraint(columnNames = { "USER_NAME" }) )
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

	@Override
	public String toString() {
		return "User [userId=" + userId + ", address=" + address + ", category=" + category + ", companyDetails="
				+ companyDetails + ", contactNumber=" + contactNumber + ", emailId=" + emailId + ", flag=" + flag
				+ ", name=" + name + ", password=" + password + ", userName=" + userName + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID", scale = 10)
	@GeneratedValue
	private int userId;

	@NotEmpty(message = "Address Should not empty")
	@Column(name = "ADDRESS", length = 50)
	private String address;

	@NotEmpty(message = "Categary Should not empty")
	@Column(name = "CATEGORY", length = 50)
	private String category;

	@NotEmpty(message = "Company detail Should not empty")
	@Column(name = "COMPANY_DETAILS", length = 50)
	private String companyDetails;

	@Length(min = 10, max = 10, message = "Enter 10-digit Mobile Number")
	// @Pattern(regexp="[0-9]",message="Enter valid Mobile Number")
	@Column(name = "CONTACT_NUMBER", length = 50)
	private String contactNumber;

	@Email(message = "Enter valid Email")
	@NotEmpty(message = "Email Should not empty")
	@Column(name = "EMAIL_ID", length = 50)
	private String emailId;

	@Column(name = "FLAGS", scale = 1)
	private int flag;

	@NotEmpty(message = "Name Should not empty")
	@Column(name = "NAME", length = 50)
	private String name;

	@NotEmpty(message = "Password Should not empty")
	@Column(name = "PASSWORD", length = 50)
	private String password;

	@NotEmpty(message = "User Name Should not empty")
	@Column(name = "USER_NAME", length = 20)
	private String userName;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "user")
	private List<Product> products;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompanyDetails() {
		return this.companyDetails;
	}

	public void setCompanyDetails(String companyDetails) {
		this.companyDetails = companyDetails;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getFlag() {
		return this.flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		String algorithm = "SHA";
		byte[] plainText = password.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		md.reset();
		md.update(plainText);
		byte[] encodedPassword = md.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				sb.append("0");
			}

			sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		System.out.println("Plain    : " + password);
		System.out.println("Encrypted: " + sb.toString());
		this.password=sb.toString();
	}

	public String getPassword() {
		return this.password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setUser(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setUser(null);

		return product;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

}