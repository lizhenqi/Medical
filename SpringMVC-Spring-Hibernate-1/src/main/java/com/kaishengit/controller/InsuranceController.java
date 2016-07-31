package com.kaishengit.controller;


import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.pojo.Insurance;
import com.kaishengit.service.InsuranceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
@Controller
public class InsuranceController {

    @Inject
    private InsuranceService insuranceService;

    //列表
    @RequestMapping(value = "/insurance", method = RequestMethod.GET)
    public String list(Model model) {
        List<Insurance> insuranceList = insuranceService.findAll();
        model.addAttribute("insuranceList", insuranceList);

        return "insurance/list";
    }


//    新建
    @RequestMapping(value = "/insurance/new", method = RequestMethod.GET)
    public String newInsurance() {

        return "insurance/new";
    }
    @RequestMapping(value = "/insurance/new", method = RequestMethod.POST)
    public String newInsuranceOne(Insurance insurance) {
        insuranceService.saveInsurance(insurance);

        return "redirect:/insurance";
    }


    //    修改
    @RequestMapping(value = "/insurance/edit/{id:\\d+}", method = RequestMethod.GET)
    public String editOne(@PathVariable Integer id, Model model) {
        Insurance insurance=insuranceService.findById(id);
        model.addAttribute("insurance",insurance);
        return "insurance/edit";
    }






    //    删除
    @RequestMapping(value = "/insurance/del/{id:\\d+}", method = RequestMethod.GET)
    public String del(@PathVariable Integer id) {
        insuranceService.del(id);

        return "redirect:/insurance";
    }




}
