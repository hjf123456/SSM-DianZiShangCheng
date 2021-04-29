package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> implements IProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> findByCategoryId(String type,Integer id) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("categorylevel"+type+"_id", id);
		return productMapper.selectByMap(map);
	}


}
