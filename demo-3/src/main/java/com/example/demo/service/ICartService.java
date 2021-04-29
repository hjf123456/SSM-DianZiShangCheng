package com.example.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Cart;
import com.example.demo.vo.CartVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
public interface ICartService extends IService<Cart> {

	public List<CartVO> findAllCartVOByUserId(Integer id);
	
}
