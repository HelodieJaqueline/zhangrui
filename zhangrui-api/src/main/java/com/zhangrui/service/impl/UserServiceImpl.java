package com.zhangrui.service.impl;

import com.zhangrui.model.User;
import com.zhangrui.repository.IUserRepository;
import com.zhangrui.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseFactoryServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public String sendMessage(String type) {
        return null;
    }
}
