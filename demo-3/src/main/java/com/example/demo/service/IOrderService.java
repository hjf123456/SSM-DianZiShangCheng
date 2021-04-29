package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Orders;
import com.example.demo.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
public interface IOrderService extends IService<Orders> {
	
	//public boolean save(Orders orders,User user);

	boolean save(Orders orders, User user, String adress, String remark);
	
}
