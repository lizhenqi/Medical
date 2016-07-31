package com.kaishengit.controller;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Controller
public class DiseaseController {

    @Inject
    private DiseaseService diseaseService;
    @Inject
    private DeptService deptService;

//    病种列表
    @RequestMapping(value = "/disease",method = RequestMethod.GET)
    public String disease(Model model){

        List<Disease> diseaseList=diseaseService.findAllDisease();
        model.addAttribute("diseaseList",diseaseList);

        List<Dept> deptList=deptService.findAll();
        model.addAttribute("deptList",deptList);

        return "disease/list";
    }


    //新建
    @RequestMapping(value = "/disease/new",method = RequestMethod.GET)
    public String deptNewOne(Model model){

        List<Dept> deptList=deptService.findAll();
        model.addAttribute("deptList",deptList);


        return "disease/new";
    }
    @RequestMapping(value = "/disease/new",method = RequestMethod.POST)
    public String deptNewTwo(Disease disease){

        diseaseService.saveDisease(disease);


        return "redirect:/disease";
    }


    //    修改
    @RequestMapping(value = "/disease/edit/{id:\\d+}", method = RequestMethod.GET)
    public String editOne(@PathVariable Integer id, Model model) {

        Disease disease=diseaseService.findById(id);
        model.addAttribute("disease",disease);

        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList", deptList);

        return "disease/edit";
    }


    //    删除
    @RequestMapping(value = "/disease/del/{id:\\d+}", method = RequestMethod.GET)
    public String del(@PathVariable Integer id) {
        diseaseService.deleteById(id);

        return "redirect:/disease";
    }



}
