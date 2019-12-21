package com.fr.springbootdemo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Fr
 * @Date 2019/12/18 19:01
 * @Version 1.0
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "helloWorld";
    }
}
