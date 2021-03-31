package io.github.yehongzhi.springmvc.mapper;

import io.github.yehongzhi.springmvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> getUserList();

}
