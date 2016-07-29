package com.kaishengit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/7/28.
 */

@Controller
public class BookController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "/login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String home(){

        return "/home";
    }




}
