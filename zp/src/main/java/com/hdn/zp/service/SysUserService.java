package com.hdn.zp.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.SysUser;
import com.hdn.zp.utils.R;

/**
 * 系统管理员表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:32
 */
public interface SysUserService extends IService<SysUser> {

    R registerMcUser(SysUser sysUser);
}
