package com.kaishengit.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/7/29.
 */
@Controller
public class DeptController {

    @RequestMapping(value = "/dept",method = RequestMethod.GET)
    public String home(){


        return "dept/list";
    }


}
