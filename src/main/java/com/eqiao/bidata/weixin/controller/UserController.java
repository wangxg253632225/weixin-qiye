package com.eqiao.bidata.weixin.controller;

import com.eqiao.bidata.weixin.intercepter.OAuthRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxinguo on 2017/7/11.
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 加载个人信息，此处添加了@OAuthRequired注解
     * @param model
     * @return
     */
    @RequestMapping(value={"/userInfo.do"})
    @OAuthRequired
    public String load(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("UserId");
        logger.info("userId: " + userId);
        model.addAttribute("userId",userId);
        return "weixin/users";
    }

}
