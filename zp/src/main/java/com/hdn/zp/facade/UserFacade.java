package com.hdn.zp.facade;

import com.hdn.zp.model.WxaSessionDto;
import com.hdn.zp.service.WxaUserService;
import com.hdn.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jack
 * @since 2020/3/9
 */
@Service
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private WxaUserService wxaUserService;

    /**
     * 微信授权接口拿到userId
     * @param code
     * @param thumb
     * @param nickName
     * @return
     */
    public int getUserId(String code,String thumb, String nickName){
        WxaSessionDto wxaSessionDto = this.wxaUserService.getWxaSessionDto(code);
        //int userId = this.userService.getOrSaveCustomer(wxaSessionDto.getOpenId(), thumb, nickName);
        //return userId;
        return 1;
    }

    /**
     * 微信登录接口拿到userId
     * @param code
     * @return
     */
    public int getUserId(String code){
        WxaSessionDto wxaSessionDto = this.wxaUserService.getWxaSessionDto(code);
        //int userId = this.userService.insertCustomerOnlyOpenId(wxaSessionDto.getOpenId());
        //return userId;
        return 1;
    }

}
