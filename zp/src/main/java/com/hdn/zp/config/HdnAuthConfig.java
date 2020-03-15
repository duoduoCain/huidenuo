package com.hdn.zp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Created by 多多啦 on 2020/3/14 0014.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class HdnAuthConfig {
    /**
     * 微信appID
     */
    public static String app_id;
    /**
     * app_secret
     */
    public static String app_secret;
    /**
     *status
     */
    public static String status;

    /**
     * redirect_url
     */
    public static String redirect_url ;

    public void setRedirect_url(String redirect_url){
        HdnAuthConfig.redirect_url = redirect_url;
    }

    public void setApp_id(String app_id){
        HdnAuthConfig.app_id = app_id;
    }

    public void setApp_secret(String app_secret){
        HdnAuthConfig.app_secret = app_secret;
    }

    public void setStatus(String status){
        HdnAuthConfig.status = status;
    }

}
