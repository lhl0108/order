package com.jbinfo.order.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jbinfo.order.base.BaseController;
import com.jbinfo.order.model.User;
import com.jbinfo.order.service.UserService;
import com.jbinfo.order.util.MyValidator;
import com.jbinfo.order.util.Result;

@Controller
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    
    @GetMapping(value="/user/add")
    public String add(String username,Model model){
        User user = new User();
        user.setUsername("lihailong");
        user.setPassword("123");
        user.setAge(5);
        userService.insert(user);
        return "user";
    }
    
    @GetMapping(value="/user/{id}")
    @ResponseBody
    public Result getUser(@PathVariable("id")String id,Model model){
        User user = userService.selectById(id);
//        model.addAttribute("user",user);

        User user2 = new User();
        String validateMessage = MyValidator.beanValidator(user2);
        System.err.println(validateMessage);
        
        return success(user2);
    }
    
    @GetMapping(value="/user/update")
    public String getUser(User user,Model model){
        System.out.println("4444444444444444444");
        return "user";
    }
    
    @GetMapping(value="/user/queryForPage")
    @ResponseBody
    public PageInfo<User> queryForPage(){
    	PageInfo<User> userList = userService.queryForPage(2,2);
        return userList;
    }
    
    
}
