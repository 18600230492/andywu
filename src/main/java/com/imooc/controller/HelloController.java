package com.imooc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andywu on 2017/11/20.
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("say")
    public String say(){
        return "StringBoot";
    }
}
