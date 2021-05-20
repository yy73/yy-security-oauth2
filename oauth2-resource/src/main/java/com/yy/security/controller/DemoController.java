package com.yy.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ywl
 * @Date 2021/5/20 20:01
 * @Description
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "hello world";
    }
}
