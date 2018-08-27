package com.zhangrui.user.repository.impl;

import com.zhangrui.user.repository.mapper.UserMapper;
import com.zhangrui.model.User;
import com.zhangrui.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
