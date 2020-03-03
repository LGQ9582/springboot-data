package com.li.controller;

import com.li.mapper.UserMapper;
import com.li.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("findUserByName")
    public User findUserByName(String name){
        return userMapper.findUserByName(name);
    }
    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll(){
       return userMapper.findAll();
    }

    @RequestMapping("find/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userMapper.findUserById(id);
    }

    @RequestMapping("add")
    public void addUser(){
        User user = new User();
        user.setName("张三");
        user.setPwd("123");

        User user2 = new User();
        user2.setName("李四");
        user2.setPwd("123");

        User user3 = new User();
        user3.setName("王五");
        user3.setPwd("123");
        userMapper.addUser(user3);
        userMapper.addUser(user2);
        userMapper.addUser(user);
    }

    @RequestMapping("update")
    public void update(){
        User user = new User();
        user.setId(2);
        user.setName("张3");
        user.setPwd("4545455");
        userMapper.updateUser(user);
    }

    @RequestMapping("del/{id}")
    public void delete(@PathVariable("id") Integer id){
        userMapper.deleteUser(id);
    }
}
