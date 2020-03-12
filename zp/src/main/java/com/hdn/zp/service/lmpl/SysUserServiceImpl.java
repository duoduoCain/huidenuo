package com.hdn.zp.service.lmpl;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hdn.zp.dao.SysUserMapper;
import com.hdn.zp.model.SysUser;
import com.hdn.zp.model.SysUserRole;
import com.hdn.zp.service.SysUserService;
import com.hdn.zp.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统管理员表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:32
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public R registerMcUser(SysUser sysUser) {

        String phonenumber = sysUser.getPhone();
        if (StringUtils.isEmpty(phonenumber))
            return R.error("手机号不能为空");
        String password = sysUser.getPassword();
        try {
            password = Base64.decodeStr(password);
        } catch (Exception e) {
        }
        if (password == null)
            return R.error("密码不能为空");
        SysUser user = new SysUser();
        user.setPhone(phonenumber);
        user.setUsername(phonenumber);
//		user.setUserName("商户" + StringUtils.getLast4(phonenumber));
        user.setUsername(phonenumber);
        user.setPassword(password);
        user.setSalt(RandomUtil.randomStr(6));
        user.setPassword(PasswordUtil.encryptPassword(user.getUsername(),user.getPassword(),user.getSalt()));
        int u =insertUser(user);
        return R.ok();
    }

    public Integer insertUser(SysUser user){
        return sysUserMapper.insert(user);
    }
}
