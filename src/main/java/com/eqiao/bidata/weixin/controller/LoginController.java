package com.eqiao.bidata.weixin.controller;

import com.eqiao.bidata.weixin.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 前台登录
 * Created by zhaoxinguo on 2017/7/7.
 */
@Controller
@RequestMapping("/user")
public class LoginController extends BaseController{

    /**
     * 前台注册
     *
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(){
        logger.info("注册成功");
        return "login";
    }

    /**
     * 前台登录
     * @param request
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,String name,String password){
        logger.info("登录成功");
        if(name != null){
            if(name.equals("zhaoxinguo") && password.equals("zhaoxinguo")){
                request.getSession().setAttribute("name",name);
                return "index";
            }
        }
        return "login";
    }

    /**
     * 前台退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("name");
        System.out.println("user logout success!");
        return "login";
    }

    /**
     * 前台个人信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/userInfo")
    public String userInfo(HttpServletRequest request){
        return "user/userInfo";
    }

}
