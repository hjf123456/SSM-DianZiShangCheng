package com.example.demo.service.impl;

import com.example.demo.entity.UserAddress;
import com.example.demo.mapper.UserAddressMapper;
import com.example.demo.service.IUserAddressService;
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
public class UserAddressService extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}
