package io.github.yehongzhi.springmvc.dao.impl;

import io.github.yehongzhi.springmvc.dao.UserDao;
import io.github.yehongzhi.springmvc.mapper.UserMapper;
import io.github.yehongzhi.springmvc.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name UserDaoImpl
 * @date 2021-03-16 00:54
 **/
@Service
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getList() {
        return userMapper.getUserList();
    }
}
