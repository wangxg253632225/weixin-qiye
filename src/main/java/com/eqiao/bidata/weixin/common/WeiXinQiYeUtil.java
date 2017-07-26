package com.eqiao.bidata.weixin.common;

import com.eqiao.bidata.weixin.util.JHttpUtils;
import com.eqiao.bidata.weixin.util.JsonMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信企业号调用类 {"errcode":0,"errmsg":"ok"} 此结果表示调用方法成功返回
 * Created by zhaoxinguo on 2017/7/11.
 */
public class WeiXinQiYeUtil {

    private static Logger logger = LoggerFactory.getLogger(WeiXinQiYeUtil.class);

    /**
     * 获取access_token
     *
     * @return access_token
     */
    public static AccessToken access_token(){
        AccessToken accessToken = null;
        Map<Object, Object> params = new HashMap<>();
        params.put("corpid",WeiXinQiYeConstants.CORPID);
        params.put("corpsecret",WeiXinQiYeConstants.CORPSECRET);
        String access_token = JHttpUtils.doGet(WeiXinQiYeConstants.ACCESS_TOKER_URL, "UTF-8", params);
        accessToken = (AccessToken) JsonMapper.fromJsonString(access_token,AccessToken.class);
        logger.info("accessToken: " + accessToken);
        if(accessToken != null){
            return accessToken;
        }
        return null;
    }

    /**
     * OAuth2验证接口根据code获取成员信息
     *
     * @param token
     * @param code
     * @return
     */
    public static Result oAuth2GetUserByCode(String token, String code, String agentId) {
        Result result = new Result();
        String menuUrl = WeiXinQiYeConstants.GET_OAUTH2_URL.replace("ACCESS_TOKEN", token).replace("CODE", code).replace("AGENTID", agentId + "");
        String userinfo = JHttpUtils.doGet(menuUrl);
        logger.info("userinfo: " + userinfo);
        JSONObject jsonObject = null;
        if (userinfo != null) {
            try {
                jsonObject = JSONObject.fromObject(userinfo);
                logger.info("jsonObject: " + jsonObject);
                if (jsonObject.getString("UserId") != null && jsonObject.getString("UserId").length() > 0) {
                    result.setErrmsg(jsonObject.getString("errmsg"));
                    result.setErrcode(jsonObject.getString("errcode"));
                    result.setUserId(jsonObject.getString("UserId"));
                } else {
                    result.setErrmsg(jsonObject.getString("errmsg"));
                    result.setErrcode(jsonObject.getString("errcode"));
                }
            } catch (Exception e) {
                result.setErrmsg("accessToken 超时......");
                result.setErrcode("42001");
            }
        }
        return result;
    }

}
