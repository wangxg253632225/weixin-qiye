package com.eqiao.bidata.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoxinguo on 2017/7/7.
 */
@Controller
public class IndexController {

    /**
     * 默认访问地址
     * @return
     */
    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }

    /**
     * 跳转到前台登录页面
     * @return
     */
    @RequestMapping(value="/login")
    public String login(){
        return "user/login";
    }

    /**
     * 跳转到前台注册页面
     * @return
     */
    @RequestMapping(value="/register")
    public String register(){
        return "user/register";
    }


}
