package com.example.demo.controller;


import com.example.demo.bo.UserInfo;
import com.example.demo.service.IUserInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestUserController {

    private final Logger log = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private IUserInterFace iuser;

    @RequestMapping("/num")
    @ResponseBody
    int home(){
        int i = iuser.getIntUser();
        return i;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    List<UserInfo> getUser(){
        //打印日志
        log.info("TestUserController getUser info!!!!!!");
        return iuser.getAllUser();
    }
}