package com.chegy122.minischool.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chegy122.minischool.model.User;
import com.chegy122.minischool.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService service;
    
    @RequestMapping("/userList")
    public List<User> getUserList(){

        return service.findAllUser();
    }
    @RequestMapping("/add")
    public String addUser(@RequestBody User user){
        if(user!=null){
            service.createUser(user);
            return "success";
        }else{
            return "error";
        }
    }


}