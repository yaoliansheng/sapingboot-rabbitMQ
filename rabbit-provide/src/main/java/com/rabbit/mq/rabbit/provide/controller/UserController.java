package com.rabbit.mq.rabbit.provide.controller;


import com.github.pagehelper.PageInfo;
import com.rabbit.mq.rabbit.provide.entity.User;
import com.rabbit.mq.rabbit.provide.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("user")
@RestController
@Api(value = "用户controller", tags = {"用户操作接口"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增", httpMethod = "POST", response = String.class, notes = "新增")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Integer add(User user) {
        return userService.insertSelective(user);
    }

    @ApiOperation(value = "删除", httpMethod = "GET", response = String.class, notes = "删除")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Integer delete(@PathVariable("id") Long id) {
        return userService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "修改", httpMethod = "POST", response = String.class, notes = "修改")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Integer update(User user) {
        return userService.updateByPrimaryKeySelective(user);
    }

    @ApiOperation(value = "根据id查询", httpMethod = "GET", response = String.class, notes = "根据id查询")
    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id) {
        return userService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查询所有", httpMethod = "GET", response = String.class, notes = "查询所有")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.selectAllUser();
    }

    @ApiOperation(value = "分页查询", httpMethod = "GET", response = String.class, notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示数据条数", dataType = "int", defaultValue = "10")
    })
    @RequestMapping(value = "findPage", method = RequestMethod.GET)
    public PageInfo<User> queryByPage(Integer pageNum, Integer pageSize) {
        return userService.queryByPage(pageNum, pageSize);
    }
}
