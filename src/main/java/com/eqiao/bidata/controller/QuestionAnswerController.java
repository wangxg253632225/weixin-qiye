package com.eqiao.bidata.weixin.controller;

import com.eqiao.bidata.weixin.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoxinguo on 2017/7/27.
 */
@Controller
@RequestMapping("/qa")
public class QuestionAnswerController extends BaseController{

    /**
     * 前台问答详情
     *
     * @return
     */
    @RequestMapping(value = "/detail")
    public String register(){
        logger.info("问答详情请求成功");
        return "qa/detail";
    }


}
