package com.hdn.zp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.SysUser;

/**
 * 系统管理员表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:32
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    Integer insertUser(SysUser sysUser);


}
