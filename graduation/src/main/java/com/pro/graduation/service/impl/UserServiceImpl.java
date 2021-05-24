package com.pro.graduation.service.impl;

import com.pro.graduation.entity.User;
import com.pro.graduation.mapper.UserMapper;
import com.pro.graduation.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hwj
 * @since 2021-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
