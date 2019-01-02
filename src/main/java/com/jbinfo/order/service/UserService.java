package com.jbinfo.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jbinfo.order.base.BaseServiceImpl;
import com.jbinfo.order.base.ServiceException;
import com.github.pagehelper.PageInfo;
import com.jbinfo.order.mapper.UserMapper;
import com.jbinfo.order.model.User;

@Service
public class UserService extends BaseServiceImpl<UserMapper, User>{
    public PageInfo<User> queryForPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        User user = new User();
        user.setAge(1);
        List<User> userList = sqlTemplate.selectList(user);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }
}
