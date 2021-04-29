package com.example.demo.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Orders;
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
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private UserAddressService userAddressService;
	
	@GetMapping("/add/{productId}/{price}/{quantity}")
	public String add(@PathVariable("productId") Integer productId,
			@PathVariable("price") Float price,@PathVariable("quantity")Integer quantity
			,HttpSession session) {
		
		Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setQuantity(quantity);
        cart.setCost(price*quantity);
        User user = (User) session.getAttribute("user");
        cart.setUserId(user.getId());
        //System.out.println(user);
        try {
            if(cartService.save(cart)){
                return "redirect:/cart/findAllCart";
            }
        } catch (Exception e) {
            return "redirect:/productCategory/list";
        }
        return null;
	}
	
	@GetMapping("/findAllCart")
	public ModelAndView findAllCart(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("settlement1");
		User user = (User)session.getAttribute("user");
        mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
       
        
        
        return mv;
		
	}
	
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id")Integer id) {
		
		cartService.removeById(id);
			
		return "redirect:/cart/findAllCart";
		 
	}
	
	
	@GetMapping("/settlement2")
	public ModelAndView settlement2(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("settlement2");
		User user = (User)session.getAttribute("user");
		mv.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
		
		QueryWrapper wrapper = new QueryWrapper();
		wrapper.eq("user_id",user.getId());
		mv.addObject("addressList",userAddressService.list(wrapper));
		 
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/updateCart/{id}/{quantity}/{cost}")
	public String updateCart(@PathVariable("id")Integer id,
			@PathVariable("quantity")Integer quantity,@PathVariable("cost")Float cost) {
		
		Cart cart = cartService.getById(id);
		cart.setQuantity(quantity);
		cart.setCost(cost);
		
		if(cartService.updateById(cart)) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	
	
}

