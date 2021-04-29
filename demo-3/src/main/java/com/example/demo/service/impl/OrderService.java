package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Cart;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAddress;
import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.UserAddressMapper;
import com.example.demo.service.IOrderService;
import com.example.demo.vo.OrderDetailVO;
import com.example.demo.vo.OrderVO;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Orders> implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	 @Autowired
	private ProductMapper productMapper;
	
	
	@Override
	public boolean save(Orders orders, User user,String address,String remark) {
		// TODO Auto-generated method stub			
		if(orders.getUserAddress().equals("newAddress")) {
			UserAddress userAddress=new UserAddress();
			userAddress.setAddress(address);
			userAddress.setRemark(remark);
			userAddress.setIsdefault(1);
			userAddress.setUserId(user.getId());	
			
			QueryWrapper wapper = new QueryWrapper();
			wapper.eq("isdefault", 1);
			wapper.eq("user_id", user.getId());
			UserAddress oldDefault=userAddressMapper.selectOne(wapper);
			
			oldDefault.setIsdefault(0);
			userAddressMapper.updateById(oldDefault);
			userAddressMapper.insert(userAddress);
			orders.setUserAddress(address);
		}		
				
		orders.setUserId(user.getId());
		orders.setLoginName(user.getLoginName());
		String seriaNumber = null;
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<32;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            seriaNumber =  result.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        orders.setSerialnumber(seriaNumber);
        
        orderMapper.insert(orders);
        //存orderDetils
        QueryWrapper wapper = new QueryWrapper();
		wapper.eq("user_id", user.getId());
        List<Cart> cartList=cartMapper.selectList(wapper);
        for(Cart cart :cartList) {
        	OrderDetail orderDetail=new OrderDetail();
        	BeanUtils.copyProperties(cart, orderDetail);
        	orderDetail.setId(null);
        	orderDetail.setOrderId(orders.getId());
        	orderDetailMapper.insert(orderDetail);
        }
        
        //清空购物车
        QueryWrapper wapper1 = new QueryWrapper();
        wapper1.eq("user_id", user.getId());
        cartMapper.delete(wapper);
        
        
		return true;
	}


	public List<OrderVO> findAllOrederVOByUserId(Integer id) {
		// TODO Auto-generated method stub
		QueryWrapper wrapper =new QueryWrapper();
		wrapper.eq("user_id", id);
		List<Orders> ordersList = orderMapper.selectList(wrapper);
		System.out.println(ordersList+"====================");
		List<OrderVO> orderVOList = ordersList.stream()
                .map(e -> new OrderVO(
                        e.getId(),
                        e.getLoginName(),
                        e.getSerialnumber(),
                        e.getUserAddress(),
                        e.getCost()
                )).collect(Collectors.toList());
		for (OrderVO orderVO : orderVOList) {
            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("order_id",orderVO.getId());
            List<OrderDetail> orderDetailList = orderDetailMapper.selectList(wrapper1);
            List<OrderDetailVO> orderDetailVOList = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetailList) {
                OrderDetailVO orderDetailVO = new OrderDetailVO();
                Product product = productMapper.selectById(orderDetail.getProductId());
                BeanUtils.copyProperties(product,orderDetailVO);
                BeanUtils.copyProperties(orderDetail,orderDetailVO);
                orderDetailVOList.add(orderDetailVO);
            }
            orderVO.setOrderDetailVOList(orderDetailVOList);
        }
        return orderVOList;
	}

}
