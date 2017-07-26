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
import java.net.URLEncoder;

/**
 * @author zhaoxinguo on 2017/7/11.
 */
@Controller
public class OAuth2Controller {

    private Logger logger = LoggerFactory.getLogger(OAuth2Controller.class);

    /**
     * 构造参数并将请求重定向到微信API获取登录信息
     * @param request
     * @param resultUrl
     * @return
     */
    @RequestMapping(value = { "/oauth2.do", "/oauth2" })
    public String Oauth2API(HttpServletRequest request, String resultUrl){
        String corpid = WeiXinQiYeConstants.CORPID;
        String redirectUrl = "";
        if(resultUrl != null){
            String requestUrl = request.getServerName();
            String contextPath = request.getContextPath();
            logger.info("domain name: " + requestUrl + " project name: " + contextPath);
            String backUrl = "http://" + requestUrl + contextPath + "/oauth2url.do?oauth2url=" + resultUrl;
            logger.info("backUrl= "+backUrl);
            redirectUrl = oAuth2Url(corpid, backUrl);
        }
        logger.info("redirectUrl: " + redirectUrl);
        return "redirect:" + redirectUrl;
    }

    /**
     * 根据code获取Userid后跳转到需要带用户信息的最终页面
     *
     * @param request
     * @param code
     *            获取微信重定向到自己设置的URL中code参数
     * @param oauth2url
     *            跳转到最终页面的地址
     * @return
     */
    @RequestMapping(value = "/oauth2url.do")
    public String Oauth2MeUrl(HttpServletRequest request, @RequestParam String code, @RequestParam String oauth2url) {
        logger.info("code: " + code);
        logger.info("oauth2url: " + oauth2url);
        AccessToken accessToken = WeiXinQiYeUtil.access_token();
        HttpSession session = request.getSession();
        if(accessToken != null && accessToken.getAccess_token() != null){
            String UserId = getMemberGuidByCode(accessToken.getAccess_token(), code, WeiXinQiYeConstants.AGENTID);
            logger.info("----------" + "UserId: " + UserId + "----------");
            if (UserId != null) {
                session.setAttribute("UserId", UserId);
            }
        }
        // 这里简单处理,存储到session中
        return "redirect:" + oauth2url;
    }

    /**
     * 构造带员工身份信息的URL
     *
     * @param corpid
     *            企业id
     * @param redirect_uri
     *            授权后重定向的回调链接地址，请使用urlencode对链接进行处理
     * state
     *            重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值
     * @return
     */
    private String oAuth2Url(String corpid, String redirect_uri) {
        try {
            redirect_uri = URLEncoder.encode(redirect_uri, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
        }
        String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + corpid + "&redirect_uri=" + redirect_uri
                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        logger.info("oauth2Url=" + oauth2Url);
        return oauth2Url;
    }

    /**
     * 调用接口获取用户信息
     *
     * @param token
     * @param code
     * @return
     */
    public String getMemberGuidByCode(String token, String code, String agentId) {
        logger.info("code==" + code + " token=" + token + " agentId=" + agentId);
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
