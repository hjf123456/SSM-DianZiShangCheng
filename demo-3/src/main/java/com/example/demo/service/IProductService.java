package com.example.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Product;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
public interface IProductService extends IService<Product> {

	public List<Product> findByCategoryId(String type,Integer id);
}
