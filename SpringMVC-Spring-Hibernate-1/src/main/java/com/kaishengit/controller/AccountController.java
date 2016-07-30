package com.kaishengit.controller;


import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountLogService;
import com.kaishengit.service.AccountService;
import com.kaishengit.util.FlashMessage;
import com.kaishengit.util.ServletUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {


    @Inject
    private AccountLogService accountLogService;
    /**
     * 登录（登录界面和提交验证）
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password,
                        RedirectAttributes redirectAttributes,
                        HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
//        获取主题。即用户
        if(subject.isAuthenticated()){
            subject.logout();
//          如果用户已经登录过了，再次登录，就先退出之前的账号。
        }
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

            subject.login(usernamePasswordToken);//login()这个方法在执行的时候会自动调用ShiroRealm实现类的验证方法。

            String ip= ServletUtil.getRemoteIp(request);//对上面的改进使其ip为127.0.0.1

            accountLogService.saveLog(ip);//TODO 保存日志待定

            return "redirect:/home";
        }catch(LockedAccountException e){

            redirectAttributes.addFlashAttribute("message",new FlashMessage(FlashMessage.STATE_ERROR,"该账户已被禁用！"));

        }catch (AuthenticationException e){
//            AuthenticationException这个异常是所有验证异常的父类，故放在最后
            redirectAttributes.addFlashAttribute("message",new FlashMessage(FlashMessage.STATE_ERROR,"账号或是密码错误！"));
        }
        return "redirect:/login";
    }


    //    首页
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){


        return "/home";
    }



    /**
     * 403错误页面
     * @return
     */
    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public String error403(){
        return "error/403";
    }

    /**
     * 安全退出
     * @return
     */
    @RequestMapping(value = "/logOut",method = RequestMethod.GET)
    public String logOut(RedirectAttributes redirectAttributes){
        SecurityUtils.getSubject().logout();

        redirectAttributes.addFlashAttribute("message",new FlashMessage("您已安全退出！"));
        return "redirect:/login";
    }




}
