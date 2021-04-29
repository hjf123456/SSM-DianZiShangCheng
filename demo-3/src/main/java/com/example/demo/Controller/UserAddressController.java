package com.example.demo.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.service.impl.CartService;
import com.example.demo.service.impl.UserAddressService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Controller
@RequestMapping("/userAddress")
public class UserAddressController {

	@Autowired
	UserAddressService userAddressService;
	@Autowired
    private CartService cartService;
	
	@GetMapping("/list")
	public ModelAndView list(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userAddressList");
		User user = (User)session.getAttribute("user");
		mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
		QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        mv.addObject("addressList",userAddressService.list(wrapper));
        return mv;
	}
	
}

