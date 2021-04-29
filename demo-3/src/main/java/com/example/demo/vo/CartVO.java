package com.example.demo.vo;

import lombok.Data;

@Data
public class CartVO {
    private Integer id;
    private Integer quantity;
    private Float cost;
    private Integer productId;
    private String name;
    private Float price;
    private String fileName;
    private Integer stock;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", quantity=" + quantity + ", cost=" + cost + ", productId=" + productId + ", name="
				+ name + ", price=" + price + ", fileName=" + fileName + ", stock=" + stock + "]";
	}
	public CartVO(Integer id, Integer quantity, Float cost, Integer productId, String name, Float price,
			String fileName, Integer stock) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.cost = cost;
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.fileName = fileName;
		this.stock = stock;
	}
	public CartVO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}
