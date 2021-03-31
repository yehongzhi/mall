package io.github.yehongzhi.springmvc.dao;

import io.github.yehongzhi.springmvc.model.User;

import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserDao
 * @date 2021-03-16 00:53
 **/
public interface UserDao {

    List<User> getList();
}
