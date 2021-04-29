package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Product implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 主键
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 名称
     */
      private String name;

      /**
     * 描述
     */
      private String description;

      /**
     * 价格
     */
      private Float price;

      /**
     * 库存
     */
      private Integer stock;

      /**
     * 分类1
     */
      private Integer categoryleveloneId;

      /**
     * 分类2
     */
      private Integer categoryleveltwoId;

      /**
     * 分类3
     */
      private Integer categorylevelthreeId;

      /**
     * 文件名称
     */
      private String fileName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCategoryleveloneId() {
		return categoryleveloneId;
	}

	public void setCategoryleveloneId(Integer categoryleveloneId) {
		this.categoryleveloneId = categoryleveloneId;
	}

	public Integer getCategoryleveltwoId() {
		return categoryleveltwoId;
	}

	public void setCategoryleveltwoId(Integer categoryleveltwoId) {
		this.categoryleveltwoId = categoryleveltwoId;
	}

	public Integer getCategorylevelthreeId() {
		return categorylevelthreeId;
	}

	public void setCategorylevelthreeId(Integer categorylevelthreeId) {
		this.categorylevelthreeId = categorylevelthreeId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", categoryleveloneId=" + categoryleveloneId + ", categoryleveltwoId=" + categoryleveltwoId
				+ ", categorylevelthreeId=" + categorylevelthreeId + ", fileName=" + fileName + "]";
	}

	public Product(Integer id, String name, String description, Float price, Integer stock, Integer categoryleveloneId,
			Integer categoryleveltwoId, Integer categorylevelthreeId, String fileName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryleveloneId = categoryleveloneId;
		this.categoryleveltwoId = categoryleveltwoId;
		this.categorylevelthreeId = categorylevelthreeId;
		this.fileName = fileName;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


      
      
}
