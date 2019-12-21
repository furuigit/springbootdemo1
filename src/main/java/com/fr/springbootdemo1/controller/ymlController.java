package com.fr.springbootdemo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Fr
 * @Date 2019/12/18 20:30
 * @Version 1.0
 */
@RestController
public class ymlController {
    @Value("${fr_name}")
    private String name;

    @Value("${fr_age}")
    private Integer age;
    @RequestMapping("yml")
    public String yml(){
        return "name:"+name+",age:"+age;
    }
}
