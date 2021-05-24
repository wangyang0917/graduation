package com.pro.graduation.service.impl;

import com.pro.graduation.entity.News;
import com.pro.graduation.mapper.NewsMapper;
import com.pro.graduation.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新闻 服务实现类
 * </p>
 *
 * @author hwj
 * @since 2021-04-05
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
