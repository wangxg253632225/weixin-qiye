package com.eqiao.bidata.weixin.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaoxinguo on 2017/7/27.
 */
public abstract class BaseController {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static final ThreadLocal<HttpServletRequest> requestContainer = new ThreadLocal<HttpServletRequest>();

    private static final ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<HttpServletResponse>();

    private static final ThreadLocal<ModelMap> modelContainer = new ThreadLocal<ModelMap>();

    /**
     * 初始化request
     *
     * @param request
     */
    @ModelAttribute
    private final void initRequest(HttpServletRequest request){
        requestContainer.set(request);
    }

    /**
     * 获取当前线程的request对象
     *
     * @return
     */
    protected final HttpServletRequest getRequest(){
        return requestContainer.get();
    }

    /**
     * 初始化response
     *
     * @param response
     */
    @ModelAttribute
    private final void initResponse(HttpServletResponse response) {
        responseContainer.set(response);
    }

    /**
     * 获取当前线程的response对象
     *
     * @return
     */
    protected final HttpServletResponse getResponse(){
        return responseContainer.get();
    }

    /**
     * 设置model
     *
     * @param modelMap
     */
    @ModelAttribute
    private final void initModelMap(ModelMap modelMap){
        modelContainer.set(modelMap);
    }

    /**
     * 获取当前线程的modelMap对象
     *
     * @return
     */
    protected final ModelMap getModelMap(){
        return modelContainer.get();
    }

}
