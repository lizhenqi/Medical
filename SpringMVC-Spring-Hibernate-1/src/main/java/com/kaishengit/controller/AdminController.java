package com.kaishengit.controller;

import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Controller
public class AdminController {

    @Inject
    private AccountService accountService;

//    列表
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index(Model model) {
        List<Account> accountList=accountService.findAll();
        model.addAttribute("accountList",accountList);


        return "admin/list";
    }
//    新建
    @RequestMapping(value = "/admin/new", method = RequestMethod.GET)
    public String newOne() {

        return "admin/new";
    }
    @RequestMapping(value = "/admin/new", method = RequestMethod.POST)
    public String newTwo(Account account) {
       accountService.save(account);
        return "redirect:/admin";
    }


//    删除
    @RequestMapping(value = "/admin/del/{id:\\d+}", method = RequestMethod.GET)
    public String del(@PathVariable Integer id) {
        accountService.del(id);

        return "redirect:/admin";
    }

//    修改(直接提交到/admin/new，它里面有save/update)
    @RequestMapping(value = "/admin/edit/{id:\\d+}", method = RequestMethod.GET)
    public String editOne(@PathVariable Integer id,Model model) {
        Account account=accountService.findById(id);
        model.addAttribute("account",account);
        return "admin/edit";
    }






}
