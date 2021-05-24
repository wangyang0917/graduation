package com.pro.graduation.service.impl;

import com.pro.graduation.entity.Classes;
import com.pro.graduation.mapper.ClassesMapper;
import com.pro.graduation.service.IClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements IClassesService {

}
