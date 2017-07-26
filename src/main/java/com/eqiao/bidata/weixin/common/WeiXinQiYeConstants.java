package com.eqiao.bidata.weixin.common;

/**
 * Created by zhaoxinguo on 2017/7/11.
 */
public class WeiXinQiYeConstants {

    // 企业应用的id
    public static final String AGENTID = "1000003";

    // 企业ID
    public static final String CORPID = "wx01ee8f220c82c2b3";

    // 应用的凭证密钥
    public static final String CORPSECRET = "uLQ3YxRHohuhKVM1EK5ahKTzucxuntKoj8i-fPmIXJU";

    // 获取access_token的url
    public static final String ACCESS_TOKER_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    // 根据code获取成员信息的url
    public static final String GET_OAUTH2_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE&agentid=AGENTID";

}
