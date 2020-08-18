package com.zh.learn.mapper;

import com.zh.learn.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @Class Name UserInfoMapper
 * @Desc
 * @create: 2020-08-18 15:27
 **/
@Mapper
public interface UserInfoMapper {

    UserInfo getOneById(Long id);

    int saveAll(List<UserInfo> userInfoList);
}
