package com.zh.learn.controler;

import com.zh.learn.domain.ResultBean;
import com.zh.learn.entity.UserInfo;
import com.zh.learn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.zh.learn.constant.StaticConstant.PREFIX_RESTFUL;

/**
 * @author Administrator
 * @Class Name UserInfoController
 * @Desc
 * @create: 2020-08-18 15:48
 **/
@RestController
@RequestMapping(PREFIX_RESTFUL + "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

        @PostMapping("/create/required")
    public ResultBean createdUserInfoRequired(@RequestBody @NotNull List<UserInfo> userInfoList) {
        return userInfoService.createdUserInfoRequired(userInfoList);
    }
}
