package com.terra.product;


public class Product {
	
	private int productId;
	private String productName;
	private String productBigImage;
	private String thumbnail;
	private String productDesc;
	private int productRatings;
	private double price;
	private boolean isActive;
	private String remarks;
	
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBigImage() {
		return productBigImage;
	}
	public void setProductBigImage(String productBigImage) {
		this.productBigImage = productBigImage;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getProductRatings() {
		return productRatings;
	}
	public void setProductRatings(int productRatings) {
		this.productRatings = productRatings;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productBigImage="
				+ productBigImage + ", thumbnail=" + thumbnail + ", productDesc=" + productDesc + ", productRatings="
				+ productRatings + ", price=" + price + ", isActive=" + isActive + "]";
	}

	
}
