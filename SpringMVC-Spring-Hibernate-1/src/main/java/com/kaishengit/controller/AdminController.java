package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/7/30.
 */
@Controller
public class AdminController {


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index() {




        return "admin/list";
    }
}
