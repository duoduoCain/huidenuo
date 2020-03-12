package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hdn.zp.model.SysUserRole;
import com.hdn.zp.service.SysUserRoleService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
   * @param userId id
   * @return R
   */
  @GetMapping("/{userId}")
  public R getById(@PathVariable("userId") Long userId){
    return new R<>(sysUserRoleService.getById(userId));
  }

  /**
   * 新增用户角色表
   * @param sysUserRole 用户角色表
   * @return R
   */

  @PostMapping
  public R save(@RequestBody SysUserRole sysUserRole){
    return new R<>(sysUserRoleService.save(sysUserRole));
  }

  /**
   * 修改用户角色表
   * @param sysUserRole 用户角色表
   * @return R
   */

  @PutMapping
  public R updateById(@RequestBody SysUserRole sysUserRole){
    return new R<>(sysUserRoleService.updateById(sysUserRole));
  }

  /**
   * 通过id删除用户角色表
   * @param userId id
   * @return R
   */

  @DeleteMapping("/{userId}")
  public R removeById(@PathVariable Long userId){
    return new R<>(sysUserRoleService.removeById(userId));
  }

}
