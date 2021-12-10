package com.zhangrui.repository.mapper.user;
import org.apache.ibatis.annotations.Param;


import com.zhangrui.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    String getNameById(@Param("id")Long id);
}