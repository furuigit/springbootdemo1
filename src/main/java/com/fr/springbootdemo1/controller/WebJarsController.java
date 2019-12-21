package com.fr.springbootdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Fr
 * @Date 2019/12/18 20:19
 * @Version 1.0
 */
@Controller
public class WebJarsController {
    @GetMapping("webjar")
    public String webjar(){
        return "index.html";
    }
}
