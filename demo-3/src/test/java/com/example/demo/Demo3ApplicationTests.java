package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.ProductCategoryMapper;
import com.example.demo.service.impl.ProductCategoryService;
import com.example.demo.service.impl.ProductService;
import com.example.demo.service.impl.UserAddressService;

@SpringBootTest
class Demo3ApplicationTests {

	@Autowired
	private ProductCategoryMapper mapper;
	
	@Autowired
	private ProductCategoryService service;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	UserAddressService userAddressService;
	
	@Test
	void contextLoads() {
		mapper.selectList(null).forEach(System.out::println);
	}

	@Test
	void test2() {
		System.out.println(service.getAllProductCategoryVO());
		
	}
	
	@Test
	void test3() {
		Map<String, Object> map=new HashMap<>();
		map.put("categorylevelthree_id", 655);
		productService.listByMap(map).forEach(System.out::println);
	}
	
	@Test
	void test4() {
		System.out.println(productService.getById(733));
	}
	
	@Test
	void test5() {
		Map<String,Object> map=new HashMap<>();
		map.put("user_id",10);
		userAddressService.listByMap(map).forEach(System.out::println);
	}
}
