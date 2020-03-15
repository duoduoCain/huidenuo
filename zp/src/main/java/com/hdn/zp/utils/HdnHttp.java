package com.hdn.zp.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

/**
 * Created by 多多啦 on 2020/3/15 0015.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@Slf4j
public class HdnHttp {

    public static final String GET = "get";

    public static final String POST = "post";

    public static String sendHttp(String url, String methodMode, Map<String, String> headers, JSONObject sendJson) {
        String returnString = "";
        try {
            if (StringUtils.isBlank(methodMode)) {
                return "error";
            }
            if (POST.equals(methodMode)) {
                returnString = sendPost(url, headers, sendJson);
            } else {
                returnString = sendGet(url, headers, sendJson);
            }
        } catch (Exception e) {
        }
        return returnString;
    }

    public static String sendGet(String url, Map<String, String> headers, JSONObject sendJson) {
        String returnString = "";
        try {
            log.debug("sendGet start url\t{}", url);
            HttpResponse execute = HttpRequest.get(url).addHeaders(headers).execute();
            returnString = execute.body();
            log.debug("sendGet response data:{} ", returnString);
        } catch (Exception e) {
            log.error("链接地址:{}；调用失败：{},请求头部为:{}", url, e, JSON.toJSONString(headers));
        } finally {
        }
        return returnString;
    }
    public static String sendPost(String url, Map<String, String> headers, JSONObject sendJson) {
        String returnString = "";
        try {
            log.debug("sendPost start url\t{}", url);
            HttpResponse execute = HttpRequest.post(url).addHeaders(headers).body(sendJson.toJSONString(), Contants.APPLICATION_JSON).execute();
            returnString = execute.body();
            JSONObject obj = JSONObject.parseObject(returnString);
            log.debug("sendPost response data\t{}", returnString);
        } catch (Exception e) {
        }
        return returnString;
    }


}
