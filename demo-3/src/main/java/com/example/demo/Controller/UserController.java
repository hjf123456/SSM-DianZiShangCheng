package com.example.demo.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.service.impl.CartService;
import com.example.demo.service.impl.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/gologin")
	public String gologin() {
		return "login";
	}
	@RequestMapping("/goregister")
	public String goregister() {
		return "register";
	}
	
	
	@PostMapping("/login")
	public String login(String loginName,String password,Model md,HttpSession session) {
		
		QueryWrapper wapper=new  QueryWrapper();
		wapper.eq("login_name", loginName);
		wapper.eq("password", password);
 		User user=userService.getOne(wapper);
 		System.out.println(user);
		if(user==null) {
			return "login";
		}else {
			session.setAttribute("user",user);
			return "redirect:/productCategory/list";
		}		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/productCategory/list";
	}
	
	
	@PostMapping("/register")
	public String register(User user,Model model) {
		boolean result = false;
        try {         
            result = userService.save(user);
        } catch (Exception e) {
            model.addAttribute("error",user.getLoginName()+"已存在！请重新输入！");
            return "register";
        }
        if(result) return "login";
        return "register";
	}
	
	
	/**
     * 用户信息
     */
    @GetMapping("/userInfo")
    public ModelAndView userInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfo");
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }
	
}

