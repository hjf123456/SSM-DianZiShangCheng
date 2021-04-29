package com.example.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.impl.CartService;
import com.example.demo.service.impl.ProductCategoryService;
import com.example.demo.service.impl.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping("/list/{type}/{id}")
	public ModelAndView list(@PathVariable("type") String type,@PathVariable("id") Integer id,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("productList");
		mv.addObject("productList", productService.findByCategoryId(type,id));
		mv.addObject("list",productCategoryService.getAllProductCategoryVO());
		
		User user = (User)session.getAttribute("user");
		if(user == null){
            mv.addObject("cartList",new ArrayList<>());
        }else{
            mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        }
		
		 
		return mv;
	}
	
	@GetMapping("/findById/{id}")
	public ModelAndView findById(@PathVariable("id")Integer id,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("productDetail");
		mv.addObject("product", productService.getById(id));
		mv.addObject("list",productCategoryService.getAllProductCategoryVO());
		
		User user = (User)session.getAttribute("user");
		if(user == null){
            mv.addObject("cartList",new ArrayList<>());
        }else{
            mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        }
		return mv;
	}
	
	
}

