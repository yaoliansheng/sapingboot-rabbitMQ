package com.rabbit.mq.rabbit.provide.service;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rabbit.mq.rabbit.provide.constants.Constants;
import com.rabbit.mq.rabbit.provide.entity.User;
import com.rabbit.mq.rabbit.provide.entity.UserExample;
import com.rabbit.mq.rabbit.provide.mapper.UserMapper;
import com.rabbit.mq.rabbit.provide.rabbit.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    Sender sender;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    IdGenerator idGenerator;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User record) {
        record.setId(idGenerator.generateId().longValue());
        int i = userMapper.insertSelective(record);
        sender.send(Constants.queueName,JSON.toJSONString(record));
        Map<String, String> map = new HashMap<>();
        map.put("A","B");
        map.put("B","C");
        map.put("C","D");
        sender.send(map);
        sender.send("TwoDirectExchange", "RoutingKeyTwo",map);
        return i;
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
