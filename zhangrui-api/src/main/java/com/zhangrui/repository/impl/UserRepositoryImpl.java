package com.zhangrui.repository.impl;

import com.zhangrui.model.User;
import com.zhangrui.repository.IUserRepository;
import com.zhangrui.repository.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
