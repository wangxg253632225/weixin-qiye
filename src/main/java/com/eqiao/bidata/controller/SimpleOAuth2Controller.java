package com.eqiao.bidata.weixin.controller;

import com.eqiao.bidata.weixin.common.AccessToken;
import com.eqiao.bidata.weixin.common.Result;
import com.eqiao.bidata.weixin.common.WeiXinQiYeConstants;
import com.eqiao.bidata.weixin.common.WeiXinQiYeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 单纯实现OAuth2验证，不使用注解及拦截器
 * Created by zhaoxinguo on 2017/7/11.
 */
@Controller
public class SimpleOAuth2Controller {

    private Logger logger = LoggerFactory.getLogger(SimpleOAuth2Controller.class);

    /**
     * 拼接网页授权链接
     * 此处步骤也可以用页面链接代替
     * @return
     */
    @RequestMapping(value = { "/oauth2wx.do" })
    public String Oauth2API(HttpServletRequest request){
        //获取项目域名
        String requestUrl = request.getServerName();
        String contextPath = request.getContextPath();
        logger.info("domain name: " + requestUrl + " project name: " + contextPath);
        //拼接微信回调地址
        String backUrl ="http://" + requestUrl + contextPath + "/oauth2me.do";
        String redirect_uri = "";
        try {
            redirect_uri = java.net.URLEncoder.encode(backUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("ecdoe error: " + e.getMessage());
        }
        String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeiXinQiYeConstants.CORPID + "&redirect_uri=" + redirect_uri
                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        return "redirect:" + oauth2Url;
    }

    /**
     * 授权回调请求处理
     * @return
     */
    @RequestMapping(value = { "/oauth2me.do" })
    public String oAuth2Url(HttpServletRequest request, @RequestParam String code){
        // 调用获取access_token的接口
        AccessToken accessToken = WeiXinQiYeUtil.access_token();
        HttpSession session = request.getSession();
        if (accessToken != null && accessToken.getAccess_token() != null) {
            // 调用获取用户信息的接口
            String UserId = getMemberGuidByCode(accessToken.getAccess_token(), code, WeiXinQiYeConstants.AGENTID);
            logger.info("UserId: " + UserId);
            if (UserId != null) {
                session.setAttribute("UserId", UserId);
                logger.info("UserId放入session成功!");
            }
        }
        // 这里简单处理,存储到session中
        return "user/result";
    }

    /**
     * 调用接口获取用户信息
     *
     * @param token
     * @param code
     * @return
     */
    public String getMemberGuidByCode(String token, String code, String agentId) {
        logger.info("code==" + code + " token=" + token + " agentId=" +agentId);
        Result result = WeiXinQiYeUtil.oAuth2GetUserByCode(token, code, agentId);
        logger.info("result= " + result);
        if (result.getErrcode().equals("0")) {
            if (result.getUserId() != null  && result.getUserId().length() > 0) {
                // 此处可以通过微信授权用code还钱的Userid查询自己本地服务器中的数据
                logger.info("result.getUserId(): " + result.getUserId());
                return result.getUserId();
            }
        }
        return "";
    }

}
