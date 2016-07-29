package com.kaishengit.controller;


import com.kaishengit.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    /**
     * 登录（登录界面和提交验证）
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {

        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String home(){


        return "/home";
    }



}
