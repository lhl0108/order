package com.jbinfo.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbinfo.order.mapper.UserMapper;
import com.jbinfo.order.model.User;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int add(User user) {
        return userMapper.add(user);
    }
    
    public User selectById(String id){
        return userMapper.selectById(id);
    }
    
}
