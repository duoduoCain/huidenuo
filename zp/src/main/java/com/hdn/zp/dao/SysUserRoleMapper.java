package com.hdn.zp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:46
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    public List<SysUserRole>  selectList(  SysUserRole sysUserRole);

    public int insertSys_user_role( List<SysUserRole> sysUserRole);

    public int  updateSys_user_role( List<SysUserRole> sysUserRole);

    public int   deleteRSys_user_role ( Long id);
}
