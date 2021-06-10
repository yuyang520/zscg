package com.example.demo.controller;


import com.example.demo.bo.UserInfo;
import com.example.demo.service.IUserInterFace;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class ThymeleafUserController {
    private final Logger log = LoggerFactory.getLogger(ThymeleafUserController.class);

    @Autowired
    private IUserInterFace iuser;

    @GetMapping("/userlist")
    public String userList(Model model){
        //打印日志
        log.info("ThymeleafUserController userList info log start");
        model.addAttribute("contents",iuser.getAllUser());
        return "/user/userlist";
    }

    @GetMapping("/form")
    public String form(Model model){
        log.info("ThymeleafUserController form info log start");
        model.addAttribute("user" , new UserInfo());
        return "/user/form";
    }

    @GetMapping("{id}")
    public String userview(@PathVariable("id") int id , Model model){
        UserInfo user = iuser.getUserById(id);
        model.addAttribute("user",user);
        return "/user/userview";
    }

    @PostMapping
    public String saveUser(UserInfo user){
        log.info("ThymeleafUserController saveUser info log start");
        if(user.getId()==0){
            iuser.insertUser(user.getCardno(),user.getPsname());
        }else{

            int a = iuser.updateById(user.getId(),user.getCardno(),user.getPsname());
        }
        return "/common/success";
    }

    @GetMapping(value = "edit/{id}")
    public String editForm(@PathVariable("id") int id , Model model){
        log.info("ThymeleafUserController editForm info log start");
        UserInfo user = iuser.getUserById(id);
        model.addAttribute("user" , user);
        return "/user/form";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") int id){
        iuser.deleteById(id);
        return "/common/success";
    }

}