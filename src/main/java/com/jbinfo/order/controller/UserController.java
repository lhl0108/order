package com.jbinfo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbinfo.order.model.User;
import com.jbinfo.order.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping(value="/user/add")
    public String add(String username,Model model){
        User user = new User();
        user.setUsername("lihailong");
        user.setPassword("123");
        user.setAge(5);
        userService.add(user);
        return "user";
    }
    
    @GetMapping(value="/user/{id}")
    public String getUser(@PathVariable("id")String id,Model model){
        User user = userService.selectById(id);
        model.addAttribute("user",user);
        System.out.println(user.getUsername());
        return "user";
    }
    
    
}
