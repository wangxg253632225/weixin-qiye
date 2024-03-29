package com.eqiao.bidata.weixin.controller;

import com.eqiao.bidata.weixin.base.BaseController;
import com.eqiao.bidata.weixin.pojo.TestTb;
import com.eqiao.bidata.weixin.service.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaoxinguo on 2017/7/7.
 */
@Controller
public class TestTbController extends BaseController{

    @Autowired
    private TestTbService testTbService;

    @RequestMapping(value = "/add")
    public String add(){
        for(int i = 0; i < 100; i++){
            TestTb testTb = new TestTb();
            testTb.setName("zhaoxinguo");
            testTb.setBirthday(new Date());
            testTbService.addTestTb(testTb);
        }
        return "main";
    }

    @RequestMapping(value = "/list")
    public void list(){
        List<TestTb> testList = testTbService.findTestList();
        logger.info("testList: " + testList);
    }

}
