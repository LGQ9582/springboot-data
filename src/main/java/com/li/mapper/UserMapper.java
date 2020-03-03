package com.li.mapper;


import com.li.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

//这个注解表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {


    List<User> findAll();
    User findUserById(Integer id);
    User findUserByName(String name);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);

}
