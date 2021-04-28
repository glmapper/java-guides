package com.glmapper.bridge.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author glmapper_2018@163.com 2021/3/3 10:14 上午
 * @since
 **/
@RestController
@RequestMapping("api")
public class TestController {

    @RequestMapping("get")
    public String get(){
        return "SUCCESS";
    }
}
