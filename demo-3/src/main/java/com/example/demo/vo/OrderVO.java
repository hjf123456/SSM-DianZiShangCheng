package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderVO {
    private Integer id;
    private String loginName;
    private String serialnumber;
    private String userAddress;
    private Float cost;
    private List<OrderDetailVO> orderDetailVOList;

    public OrderVO(Integer id, String loginName, String serialnumber, String userAddress, Float cost) {
        this.id = id;
        this.loginName = loginName;
        this.serialnumber = serialnumber;
        this.userAddress = userAddress;
        this.cost = cost;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public List<OrderDetailVO> getOrderDetailVOList() {
		return orderDetailVOList;
	}
	public void setOrderDetailVOList(List<OrderDetailVO> orderDetailVOList) {
		this.orderDetailVOList = orderDetailVOList;
	}
	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", loginName=" + loginName + ", serialnumber=" + serialnumber + ", userAddress="
				+ userAddress + ", cost=" + cost + ", orderDetailVOList=" + orderDetailVOList + "]";
	}
	public OrderVO(Integer id, String loginName, String serialnumber, String userAddress, Float cost,
			List<OrderDetailVO> orderDetailVOList) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.serialnumber = serialnumber;
		this.userAddress = userAddress;
		this.cost = cost;
		this.orderDetailVOList = orderDetailVOList;
	}
	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
