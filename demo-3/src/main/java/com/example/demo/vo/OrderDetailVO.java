package com.example.demo.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
    private String name;
    private String fileName;
    private Integer quantity;
    private Float price;
    private Float cost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "OrderDetailVO [name=" + name + ", fileName=" + fileName + ", quantity=" + quantity + ", price=" + price
				+ ", cost=" + cost + "]";
	}
	public OrderDetailVO(String name, String fileName, Integer quantity, Float price, Float cost) {
		super();
		this.name = name;
		this.fileName = fileName;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}
	public OrderDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
