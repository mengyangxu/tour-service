package com.xmy.service.controller;

import com.xmy.bean.bean.User;
import com.xmy.service.dao.UserDao;
import com.xmy.service.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: xumengyang
 * @Date: Created in 16:04 2018/2/27
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password){
        return userDao.getByUsernameAndPassword(username, password);
    }

    @RequestMapping("/userList")
    public Object userList(){
        return new JsonResponse(userDao.userList());
    }

    @RequestMapping("/list")
    public List<User> list(){
        return userDao.userList();
    }



}
