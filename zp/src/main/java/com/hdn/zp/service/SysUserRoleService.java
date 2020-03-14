package com.hdn.zp.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:46
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    public List<SysUserRole> selectList(@Param("sysUserRole")  SysUserRole sysUserRole);

    public int insertSys_user_role(@Param("sysUserRole") List<SysUserRole> sysUserRole);

    public int  updateSys_user_role(@Param("sysUserRole") List<SysUserRole> sysUserRole);

    public int   deleteRSys_user_role (@Param("id") Long id);
}
