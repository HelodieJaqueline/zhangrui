package com.zhangrui.user.repository;


import com.zhangrui.model.User;

public interface IUserRepository {
    User getById(Long id);
}
