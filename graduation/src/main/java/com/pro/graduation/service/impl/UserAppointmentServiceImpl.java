package com.pro.graduation.service.impl;

import com.pro.graduation.entity.UserAppointment;
import com.pro.graduation.mapper.UserAppointmentMapper;
import com.pro.graduation.service.IUserAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户班级关系表 服务实现类
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@Service
public class UserAppointmentServiceImpl extends ServiceImpl<UserAppointmentMapper, UserAppointment> implements IUserAppointmentService {

}
