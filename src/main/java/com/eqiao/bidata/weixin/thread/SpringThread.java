package com.eqiao.bidata.weixin.thread;

/**
 * Created by zhaoxinguo on 2017/7/26.
 */
public class SpringThread extends Thread {

    private int parameter;

    public SpringThread(int parameter){
        this.parameter = parameter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :执行了..." + parameter);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
