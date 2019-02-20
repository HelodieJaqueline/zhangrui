package com.zhangrui.service;


import com.zhangrui.model.User;

public interface IUserService {
    User getById(Long id);

    String sendMessage(String type);
}
