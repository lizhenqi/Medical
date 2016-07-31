package com.kaishengit.controller;

import com.kaishengit.pojo.Dept;
import com.kaishengit.service.DeptService;
import com.kaishengit.util.ShiroUtil;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
@Controller
public class DeptController {

    @Inject
    private DeptService deptService;


    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public String home(Model model) {

        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList", deptList);


        return "dept/list";
    }

    //新建
    @RequestMapping(value = "/dept/new", method = RequestMethod.GET)
    public String New() {
        return "dept/new";
    }

    @RequestMapping(value = "/dept/new", method = RequestMethod.POST)
    public String deptNew(Dept dept) {
        deptService.saveDept(dept);

        return "redirect:/dept";
    }


    //    修改(直接提交到/dept/new，它里面有save/update)
    @RequestMapping(value = "/dept/edit/{id:\\d+}", method = RequestMethod.GET)
    public String editOne(@PathVariable Integer id, Model model) {

        Dept dept = deptService.findById(id);
        model.addAttribute("dept", dept);
        return "dept/edit";
    }



    //    删除
    @RequestMapping(value = "/dept/del/{id:\\d+}", method = RequestMethod.GET)
    public String del(@PathVariable Integer id) {
        deptService.deleteById(id);

        return "redirect:/dept";
    }


}
