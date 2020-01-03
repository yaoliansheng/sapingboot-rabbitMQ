package com.rabbit.mq.rabbit.consumer.service;


import com.github.pagehelper.PageInfo;
import com.rabbit.mq.rabbit.consumer.entity.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    List<User> selectAllUser();

    PageInfo<User> queryByPage(Integer pageNum, Integer pageSize);

}
