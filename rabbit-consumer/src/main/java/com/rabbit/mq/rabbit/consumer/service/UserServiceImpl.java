package com.rabbit.mq.rabbit.consumer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rabbit.mq.rabbit.consumer.entity.User;
import com.rabbit.mq.rabbit.consumer.entity.UserExample;
import com.rabbit.mq.rabbit.consumer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public List<User> selectAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public PageInfo<User> queryByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectByExample(new UserExample());
        return new PageInfo<>(users);
    }
}
