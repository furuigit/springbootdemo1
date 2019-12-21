package com.fr.springbootdemo1.controller;

import com.fr.pojo.User;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Fr
 * @Date 2019/12/18 19:11
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("findOne")
    public User findOne(){
        return new User(1,"zs",new Date());
    }

    @RequestMapping("getAll")
    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        list.add(new User(2,"lisi",new Date()));
        list.add(new User(3,"wangwu",new Date()));
        list.add(new User(4,"tangliu",new Date()));
        return list;
    }

    @RequestMapping("findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return new User(id,"xiaoming",new Date());
    }

    @RequestMapping("findByUser")
    public User findByUser(@RequestBody User user){
        return user;
    }

    @RequestMapping("findByUserNobody")
    public User findByUserNobody(User user){
        return user;
    }
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
}
