package com.hdn.zp.service.lmpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.SysUserRoleMapper;
import com.hdn.zp.model.SysUserRole;
import com.hdn.zp.service.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:46
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    private   SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysUserRole> selectList(SysUserRole sysUserRole) {
        return sysUserRoleMapper.selectList(sysUserRole);
    }

    @Override
    public int insertSys_user_role(List<SysUserRole> sysUserRole) {
        return sysUserRoleMapper.insertSys_user_role(sysUserRole);
    }

    @Override
    public int updateSys_user_role(List<SysUserRole> sysUserRole) {
        return  sysUserRoleMapper.updateSys_user_role(sysUserRole);
    }

    @Override
    public int deleteRSys_user_role(Long id) {
        return sysUserRoleMapper.deleteRSys_user_role(id);
    }

}
