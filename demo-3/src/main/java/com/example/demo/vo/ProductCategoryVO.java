package com.example.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class ProductCategoryVO {

	private Integer id;
	private String name;
	private List<ProductCategoryVO> children;
	private String bannerImg;
	private String topImg;
	private List<ProductVO> productVOList;
	
	
	public List<ProductVO> getProductVOList() {
		return productVOList;
	}
	public void setProductVOList(List<ProductVO> productVOList) {
		this.productVOList = productVOList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	public String getTopImg() {
		return topImg;
	}
	public void setTopImg(String topImg) {
		this.topImg = topImg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductCategoryVO> getChildren() {
		return children;
	}
	public void setChildren(List<ProductCategoryVO> children) {
		this.children = children;
	}
	
	
	
	public ProductCategoryVO(Integer id, String name, List<ProductCategoryVO> children, String bannerImg, String topImg,
			List<ProductVO> productVOList) {
		super();
		this.id = id;
		this.name = name;
		this.children = children;
		this.bannerImg = bannerImg;
		this.topImg = topImg;
		this.productVOList = productVOList;
	}
	@Override
	public String toString() {
		return "ProductCategoryVO [id=" + id + ", name=" + name + ", children=" + children + ", bannerImg=" + bannerImg
				+ ", topImg=" + topImg + "]";
	}
	public ProductCategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCategoryVO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
