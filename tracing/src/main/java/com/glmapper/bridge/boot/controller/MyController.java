package com.glmapper.bridge.boot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController()
public class MyController {
    private static final Log logger = LogFactory.getLog(MyController.class);
    @RequestMapping("test")
    public String test() {
        logger.info("this is test log ....");
        return "SUCCESS";
    }
}
