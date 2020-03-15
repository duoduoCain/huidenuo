package com.hdn.zp.service.lmpl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdn.zp.config.HdnAuthConfig;
import com.hdn.zp.model.AuthVo;
import com.hdn.zp.model.SysUser;
import com.hdn.zp.model.UserAccessToken;
import com.hdn.zp.model.WechatUser;
import com.hdn.zp.service.SysUserService;
import com.hdn.zp.service.UserService;
import com.hdn.zp.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by 多多啦 on 2020/3/15 0015.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@Service
@Slf4j
public class WechatLoginService {


    @Autowired
    private HttpsClientService httpsClientService;

    @Autowired
    private UserService userService;//TODO还需入库

    public R<UserAccessToken> getAccessToken(String code){

        String code2AccessToken = AuthVo.CODE_2_ACCESS_TOKEN;

//        "https://api.weixin.qq.com" +
//                "/sns/oauth2/access_token?" +
//                "appid=%s&" +
//                "secret=%s&" +
//                "code=%s&" +
//                "grant_type=authorization_code";

        String format = String.format(code2AccessToken, HdnAuthConfig.app_id, HdnAuthConfig.app_secret, code);
        String wechatReturn = HdnHttp.sendGet(format, null, null);
        if(StringUtils.isBlank(wechatReturn)){
            log.error("微信接口未有返回");
            return R.error("微信接口未有返回");
        }
        JSONObject jsonWechatReturn = (JSONObject) JSONObject.parse(wechatReturn);
        String accessToken = jsonWechatReturn.getString(AuthVo.WECHAT_ACCESS_TOKEN);
        String refreshToken = jsonWechatReturn.getString(AuthVo.WECHAT_REFRESH_TOKEN);
        String openId = jsonWechatReturn.getString(AuthVo.WECHAT_OPEN_ID);
        ObjectMapper objectMapper = new ObjectMapper();
        UserAccessToken userAccessToken =null;
        try {
             userAccessToken = objectMapper.readValue(wechatReturn, UserAccessToken.class);
        } catch (JsonProcessingException e) {
            log.error("出现错误");
            return new R(e);
        }
        return R.ok(userAccessToken);
//        getUserInfo(openId,accessToken);


//        {
//            "access_token": "ACCESS_TOKEN",
//                "expires_in": 7200,
//                "refresh_token": "REFRESH_TOKEN",
//                "openid": "OPENID",
//                "scope": "SCOPE",
//                "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
//        }
//        JSONObject parse = (JSONObject) JSONObject.parse(post);
//        String accessToken = parse.getString(ACCESS_TOKEN);
//        String openId = parse.getString(OPEN_ID);

//        log.debug("传过来的status：{}" + state);
//        return R.ok("ok");
    }

    public R<WechatUser> getUserInfo(String openId, String accessToken){

        String accessToken2UserinfoccessToken = AuthVo.ACCESS_TOKEN_2_USERINFO;
        String url = String.format(accessToken2UserinfoccessToken, accessToken, openId);
        String getString = HdnHttp.sendGet(url, null, null);

        if(!AuthVo.validateWechatString(getString,2)){
            return R.error("返回有误");
        }

        log.info("获取到接口返回:{}",getString);
        ObjectMapper objectMapper = new ObjectMapper();
        WechatUser wechatUser =null;
        try {
            wechatUser = objectMapper.readValue(getString, WechatUser.class);
        } catch (JsonProcessingException e) {
            log.error("出现错误");
            return new R(e);
        }
        return R.ok(wechatUser);
//        {
//            "openid": "OPENID",
//                "nickname": "NICKNAME",
//                "sex": 1,
//                "province": "PROVINCE",
//                "city": "CITY",
//                "country": "COUNTRY",
//                "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
//                "privilege": ["PRIVILEGE1", "PRIVILEGE2"],
//            "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
//        }
//        JSONObject userInfoJson = (JSONObject) JSONObject.parse(getString);
//        String nickname = userInfoJson.getString(AuthVo.NICK_NAME);
//        String sex = userInfoJson.getString(AuthVo.SEX);
//        String province = userInfoJson.getString(AuthVo.PROVINCE);
//        String city = userInfoJson.getString(AuthVo.CITY);
//        String country = userInfoJson.getString(AuthVo.COUNTRY);
//        String headimgurl = userInfoJson.getString(AuthVo.HEADIMGURL);
//        JSONArray jsonArray = userInfoJson.getJSONArray(AuthVo.PRIVILEGE);
//        SysUser user =new SysUser();
//        //user.setUsername(nickname);
//        user.setWxOpenid(openId);
//
//        return R.ok("ok");
    }

    public R<String> getUnionId(){
        return R.ok("ok");
    }

}
