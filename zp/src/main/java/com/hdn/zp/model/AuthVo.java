package com.hdn.zp.model;

import com.hdn.zp.config.HdnAuthConfig;
import com.hdn.zp.utils.StringUtils;

/**
 * Created by 多多啦 on 2020/3/14 0014.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
public class AuthVo {

    /**
     * 这是获取access_token
     */
    public static final  String CODE_2_ACCESS_TOKEN = "https://api.weixin.qq.com" +
            "/sns/oauth2/access_token?" +
            "appid=%s&" +
            "secret=%s&" +
            "code=%s&" +
            "grant_type=authorization_code";




    /**
     * 这是获取CODE
     */
    public static final String GET_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
            "appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state="+ HdnAuthConfig.status+"#wechat_redirect";


    /**
     * 这是获取user_info
     */
    public static final  String ACCESS_TOKEN_2_USERINFO = "api.weixin.qq.com/sns/userinfo" +
            "?access_token=%s&" +
            "openid=%s";


    public static final String WECHAT_ACCESS_TOKEN = "access_token";
    public static final String WECHAT_REFRESH_TOKEN = "refresh_token";
    public static final String WECHAT_OPEN_ID = "nickname";
    public static final String NICK_NAME = "openid";
    public static final String SEX = "sex";
    public static final String CITY = "city";
    public static final String PROVINCE = "provice";
    public static final String COUNTRY = "country";
    public static final String HEADIMGURL = "headimgurl";
    public static final String PRIVILEGE = "privilege";

    /**
     *
     * @param wechatString
     * @param wherePlace  0:表示获取code的时候  1: 表示获取access_token的时候  2：表示获取userinfo的时候
     * @return
     */
    public static boolean  validateWechatString(String wechatString,int wherePlace){//TODO

        if(StringUtils.isBlank(wechatString)){
            return false;
        }

        if(0==wherePlace){
            return true;
        }
        if(1==wherePlace){
            return true;
        }
        if(2==wherePlace){
            return true;
        }
        return false;
    }

}
