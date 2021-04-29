package com.example.demo.Controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Orders;
import com.example.demo.entity.User;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.impl.CartService;
import com.example.demo.service.impl.OrderService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
    private CartService cartService;
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	
	@PostMapping("/settlement3")
	public ModelAndView settlement3(Orders orders,HttpSession session,String address,String remark) {
		
		User user = (User)session.getAttribute("user");		
		orderService.save(orders,user,address,remark);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("settlement3");
		mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
	    mv.addObject("orders",orders);
		return  mv;
	}
	
	@GetMapping("/list")
	public ModelAndView list(HttpSession session) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("orderList");
		User user = (User)session.getAttribute("user");	
		 mv.addObject("list",orderService.findAllOrederVOByUserId(user.getId()));
	     mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
	     
	     return mv;
		
	}
	
	
	
}

