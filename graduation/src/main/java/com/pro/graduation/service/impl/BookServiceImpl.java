package com.pro.graduation.service.impl;

import com.pro.graduation.entity.Book;
import com.pro.graduation.mapper.BookMapper;
import com.pro.graduation.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书籍信息 服务实现类
 * </p>
 *
 * @author hwj
 * @since 2021-05-09
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
