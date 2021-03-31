package io.github.yehongzhi.springmvc.service;

import io.github.yehongzhi.springmvc.model.User;

import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserService
 * @date 2021-03-16 00:55
 **/
public interface UserService {

    List<User> getList();

    User queryByUserName(String userName);
}
