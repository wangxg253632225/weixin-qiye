package com.eqiao.bidata.weixin.test;

import com.eqiao.bidata.weixin.thread.SpringThread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

/**
 * Created by zhaoxinguo on 2017/7/26.
 */
public class SpringThreadTest {

    public static void main(String [] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/bidata/config/spring-*.xml");
        TaskExecutor taskExecutor = (TaskExecutor) applicationContext.getBean("taskExecutor");
        for (int i = 0; i < 100; i++) {
            SpringThread springThread = new SpringThread(i);
            taskExecutor.execute(springThread);
        }
        System.out.println("main process is finish ...... ");
    }

}
