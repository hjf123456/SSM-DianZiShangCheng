package com.example.demo.service.impl;

import com.example.demo.entity.OrderDetail;
import com.example.demo.mapper.OrderDetailMapper;
import com.example.demo.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 建强
 * @since 2021-04-20
 */
@Service
public class OrderDetailService extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
