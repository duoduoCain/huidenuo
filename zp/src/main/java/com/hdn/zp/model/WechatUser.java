package com.hdn.zp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by 多多啦 on 2020/3/15 0015.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@Data
public class WechatUser {

    // openId,标识该公众号下面的该用户的唯一Id
    @JsonProperty("openid")
    private String openId;
    // 用户昵称
    @JsonProperty("nickname")
    private String nickName;
    // 性别
    @JsonProperty("sex")
    private int sex;
    // 省份
    @JsonProperty("province")
    private String province;
    // 城市
    @JsonProperty("city")
    private String city;
    // 区
    @JsonProperty("country")
    private String country;
    // 头像图片地址
    @JsonProperty("headimgurl")
    private String headimgurl;
    // 语言
    @JsonProperty("language")
    private String language;
    @JsonProperty("privilege")
    private String[] privilege;
}
