package com.eqiao.bidata.weixin.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaoxinguo on 2017/7/7.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    /**
     * 无效请求跳转到404页面
     */
    private static final String invalidUrl = "/404";

    String [] notFilter = new String[]{"/index","/login","/user/login","/back/index","/back/login"};

    /**
     * 预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("===========HandlerInterceptor1 preHandle===========");
        long beginTime = System.currentTimeMillis();//1.开始时间
        startTimeThreadLocal.set(beginTime);//2.线程绑定变量(该数据只有当前请求的线程可见)

        String path = request.getServletPath();
        logger.info("get url " + path);
        //1.请求到登录页面 放行
        for(String str : notFilter){
            if(request.getServletPath().startsWith(str)){
                return true;
            }
        }

        //2.TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求

        if(path.contains("back")){

            //3.2如果后台用户已经登录 放行
            if(request.getSession().getAttribute("names") != null){
                //更好的实现方式的使用cookie
                return true;
            }

        }else {

            //3.如果用户已经登录 放行
            if (request.getSession().getAttribute("name") != null) {
                //更好的实现方式的使用cookie
                return true;
            }
        }


        //4、非法请求 即这些请求需要登录后才能访问
        //重定向到登录页面
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }

    /**
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），
     * 此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("===========HandlerInterceptor1 postHandle===========");
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中preHandle返回true的拦截器的afterCompletion。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("===========HandlerInterceptor1 afterCompletion===========");
        long endTime = System.currentTimeMillis();//2.结束时间
        Long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量(开始时间)
        long consumeTime = endTime-beginTime;//3.消耗的时间
        if(consumeTime > 500){//此处认为处理时间超过500毫秒的请求为慢请求
            //记录到日志文件
            logger.info(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
        }
    }

}
