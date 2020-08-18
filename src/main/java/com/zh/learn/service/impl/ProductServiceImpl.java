package com.zh.learn.service.impl;

import com.zh.learn.mapper.ProductMapper;
import com.zh.learn.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Class Name ProductServiceImpl
 * @Desc
 * @create: 2020-08-18 16:04
 **/
@Primary
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductMapper productMapper;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
}
