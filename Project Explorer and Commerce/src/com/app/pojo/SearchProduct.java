package com.app.pojo;

public class SearchProduct {
	private double minPrice;
	private double maxPrice;
	private String keyword;
	private String category;
	private int columnNumber;

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}

	@Override
	public String toString() {
		return "SearchProduct [minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", keyword=" + keyword + ", category="
				+ category + ", columnNumber=" + columnNumber + "]";
	}

	
}
