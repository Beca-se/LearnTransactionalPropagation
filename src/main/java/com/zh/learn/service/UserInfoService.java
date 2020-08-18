package com.zh.learn.service;

import com.zh.learn.domain.ResultBean;
import com.zh.learn.entity.UserInfo;

import java.util.List;

/**
 * @author Administrator
 * @Class Name UserInfoService
 * @Desc
 * @create: 2020-08-18 15:51
 **/
public interface UserInfoService {

    ResultBean createdUserInfoRequired(List<UserInfo> userInfoList);

}
