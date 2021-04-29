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
public class ProductCategory implements Serializable {

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
     * 父级目录id
     */
      private Integer parentId;

      /**
     * 级别(1:一级 2：二级 3：三级)
     */
      private Integer type;

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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId=" + parentId + ", type=" + type + "]";
	}

	public ProductCategory(Integer id, String name, Integer parentId, Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
	}

	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

      
      
}
