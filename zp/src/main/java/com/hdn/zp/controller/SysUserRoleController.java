package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hdn.zp.model.Resume;
import com.hdn.zp.model.SysUserRole;
import com.hdn.zp.service.SysUserRoleService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户角色表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:46
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysuserrole")
public class SysUserRoleController {

  private final SysUserRoleService sysUserRoleService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param sysUserRole 用户角色表
   * @return
   */
  @GetMapping("/page")
  public R getSysUserRolePage(Page page, SysUserRole sysUserRole) {
    return  new R<>(sysUserRoleService.page(page,Wrappers.query(sysUserRole)));
  }


  /**
   * 通过id查询用户角色表
   * @param sysUserRole id
   * @return R
   */
  @GetMapping
  public List<SysUserRole> getselectListSysUserRole(SysUserRole  sysUserRole){
    return sysUserRoleService.selectList(sysUserRole);
  }
  /**
   * 新增用户角色表
   * @param sysUserRole 用户角色表
   * @return R
   */

  @PostMapping
  public  int  getinsertSysUserRole(List<SysUserRole> sysUserRole){
    return sysUserRoleService.insertSys_user_role(sysUserRole);
  }

  /**
   * 修改用户角色表
   * @param sysUserRole 用户角色表
   * @return R
   */

  @PutMapping
  public  int  getupdateSysUserRole(List<SysUserRole> sysUserRole){
    return sysUserRoleService.updateSys_user_role(sysUserRole);
  }

  /**
   * 通过id删除用户角色表
   * @param id id
   * @return R
   */

  @DeleteMapping("/{id}")
  public  int  getdeleteSysUserRole(Long  id){
    return sysUserRoleService.deleteRSys_user_role(id);
  }
}
