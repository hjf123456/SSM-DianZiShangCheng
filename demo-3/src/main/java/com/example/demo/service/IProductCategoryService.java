package com.example.demo.service;

import com.example.demo.entity.ProductCategory;
import com.example.demo.vo.ProductCategoryVO;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
public interface IProductCategoryService extends IService<ProductCategory> {

	public List<ProductCategoryVO> getAllProductCategoryVO();
}
