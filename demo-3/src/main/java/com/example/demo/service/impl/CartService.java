package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.MallException;
import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ICartService;
import com.example.demo.vo.CartVO;

import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Service
@Slf4j
public class CartService extends ServiceImpl<CartMapper, Cart> implements ICartService {

	@Autowired
	private CartMapper cartMapper;
	@Autowired
    private ProductMapper productMapper;
	
	public List<CartVO> findAllCartVOByUserId(Integer id) {
		List<CartVO> cartVOList = new ArrayList<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",id);
        List<Cart> cartList = cartMapper.selectList(wrapper);
        for (Cart cart : cartList) {
            CartVO cartVO = new CartVO();
            Product product = productMapper.selectById(cart.getProductId());
            BeanUtils.copyProperties(product,cartVO);
            BeanUtils.copyProperties(cart,cartVO);
            cartVO.setProductId(product.getId());
            cartVOList.add(cartVO);
        }
        return cartVOList;
	}

	@Override
	public boolean save(Cart entity) {
		// TODO Auto-generated method stub
		Product product=productMapper.selectById(entity.getProductId());
		Integer stock = product.getStock() - entity.getQuantity();
		if(stock < 0){
            log.error("【添加购物车】库存不足！stock={}");
            throw new MallException(ResultEnum.STOCK_ERROR);
        }
			
		product.setStock(stock);
        productMapper.updateById(product);
        if(cartMapper.insert(entity) == 1){
            return true;
        }
        return false;
	}
	
	
}
