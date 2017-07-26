package com.eqiao.bidata.weixin.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台登录
 * Created by zhaoxinguo on 2017/7/19.
 */
@Controller
@RequestMapping("/back")
public class AdminLoginController {

    /**
     * 跳转到后台登录页
     * @return
     */
    @RequestMapping(value = "/index")
    public String invalid(){
        return "/admin/login";
    }

    /**
     * 后台登录
     * @param request
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, String name, String password){
        if(name != null){
            if(name.equals("admin") && password.equals("admin")){
                request.getSession().setAttribute("names",name);
                return "/admin/index";
            }
        }
        return "/admin/login";
    }

    /**
     * 后台退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("names");
        System.out.println("back logout success!");
        return "login";
    }

    /**
     * 用户管理
     * @param request
     * @return
     */
    @RequestMapping(value = "/users")
    public String users(HttpServletRequest request){
        return "/admin/users";
    }

}
