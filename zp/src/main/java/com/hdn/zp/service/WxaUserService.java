package com.hdn.zp.service;

import com.hdn.zp.model.WxaSessionDto;

/**
 * @author Jack
 * @since 2020/3/8
 */
public interface WxaUserService {

    /**
     * 根据code，去微信接口调取用户信息
     * @param code
     * @return
     */
    WxaSessionDto getWxaSessionDto(String code);

}
