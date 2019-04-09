package com.fev.mapper;

import com.fev.pojo.User;

/**
 * * Description:
 * * Author: fev
 * * Date: 2019/4/9 22:26
 * * version: V1.0
 */
public interface UserMapper {

    Integer insertUser(User user);
    User selectById(Integer id);

}
