package com.zh.learn.service.impl;

import com.zh.learn.domain.ResultBean;
import com.zh.learn.entity.UserInfo;
import com.zh.learn.mapper.UserInfoMapper;
import com.zh.learn.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author Administrator
 * @Class Name UserInfoServiceImpl
 * @Desc
 * @create: 2020-08-18 15:52
 **/
@Service
@Primary
public class UserInfoServiceImpl implements UserInfoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     *
     *  {@link Propagation.REQUIRED} 默认值, 如果上下文存在事务则加入当前事务,否则创建一个新事物
     *  {@link Propagation.SUPPORTS} 支持当前事务，如果当前没有事务，就以非事务方式执行。
     *  {@link Propagation.MANDATORY} 支持当前事务，如果当前没有事务，就抛出异常。
     *  {@link Propagation.REQUIRES_NEW} 新建事务，如果当前存在事务，把当前事务挂起。
     *  {@link Propagation.NOT_SUPPORTED} 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     *  {@link Propagation.NEVER} 以非事务方式执行，如果存在事务则抛出异常
     *  {@link Propagation.NESTED} 支持当前事务，如果当前事务存在，则执行一个嵌套事务，如果当前没有事务，就新建一个事务。
     *
     */

    /**
     *
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ResultBean createdUserInfoRequired(List<UserInfo> userInfoList) {
        try {
            System.out.println("===========");
            int i = userInfoMapper.saveAll(userInfoList);
            System.out.println("插入数据为: " + i);
            assertFalse();
            System.out.println("我是事务地址"+TransactionAspectSupport.currentTransactionStatus());
            return ResultBean.isOK("SUCCESSFUL");
        } catch (Exception ex) {
            logger.info("测试Required错误,原因是: {}.", ex);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultBean.isError();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public boolean assertFalse() {
        try {
            throw new IllegalArgumentException("失败回滚");
        }catch (Exception ex){
            System.out.println("我失败了");
            System.out.println("我是事务地址"+TransactionAspectSupport.currentTransactionStatus());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }
}
