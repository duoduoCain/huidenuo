package com.hdn.zp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hdn.zp.common.BaseController;
import com.hdn.zp.config.HdnAuthConfig;
import com.hdn.zp.model.AuthVo;
import com.hdn.zp.service.lmpl.WechatLoginService;
import com.hdn.zp.utils.Contants;
import com.hdn.zp.utils.HttpsClientService;
import com.hdn.zp.utils.R;
import com.hdn.zp.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 多多啦 on 2020/3/14 0014.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController{


    @Autowired
    private WechatLoginService wechatLoginService;

    private static final String ACCESS_TOKEN ="access_token";

    private static final String OPEN_ID ="openid";

    @RequestMapping("/wechatLogin")
    public void login(HttpServletResponse response){
        String url = AuthVo.GET_CODE;
//        "https://open.weixin.qq.com/connect/oauth2/authorize?" +
//                "appid=%s&redirect_uri=%s&response_type=code&scope=scope&state="+ HdnAuthConfig.status+"#wechat_redirect";

        String encode = "";
        try {
             encode= URLEncoder.encode(HdnAuthConfig.redirect_url+"hdn/auth/wechatAuthRedirect", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("微信编码url时出现错误");
        }
        if(StringUtils.isBlank(encode)){
        }
        String format = String.format(url, HdnAuthConfig.app_id,encode);
        System.out.println(format);
        try {
            response.sendRedirect(format);
        } catch (IOException e) {
            log.error("发送微信是出现错误");
        }
    }


    @RequestMapping("/wechatAuthRedirect")
    public void wechatAuthRedirect(@RequestParam("state")String state,
                                   @RequestParam("code")String code,
                                   HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (StringUtils.isBlank(state)) {
                out.append("<html><body>无法获取回调的state!<script>window.close()</script></body></html>");
            }
            if(!HdnAuthConfig.status.equals(state)){
                log.error("授权时被crsf注入了");
                out.append("<html><body>授权时被crsf注入了!<script>window.close()</script></body></html>");
                return;
            }
            wechatLoginService.getAccessToken(code);
        } catch (IOException e) {
            log.error("系统异常:{}", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


}
