package com.jbinfo.order.mapper;

import com.jbinfo.order.model.User;


public interface UserMapper {
    int add(User user);
    User selectById(String id);
}
