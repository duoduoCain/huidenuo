package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.SysUser;
import com.hdn.zp.service.SysUserService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 系统管理员表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:32
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysuser")
public class SysUserController {

  private final SysUserService sysUserService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param sysUser 系统管理员表
   * @return
   */
  @GetMapping("/page")
  public R getSysUserPage(Page page, SysUser sysUser) {
    return  new R<>(sysUserService.page(page,Wrappers.query(sysUser)));
  }


  /**
   * 通过id查询系统管理员表
   * @param userId id
   * @return R
   */
  @GetMapping("/{userId}")
  public R getById(@PathVariable("userId") Long userId){
    return new R<>(sysUserService.getById(userId));
  }

  /**
   * 新增系统管理员表
   * @param sysUser 系统管理员表
   * @return R
   */

  @PostMapping
  public R save(@RequestBody SysUser sysUser){
    return new R<>(sysUserService.save(sysUser));
  }

  /**
   * 修改系统管理员表
   * @param sysUser 系统管理员表
   * @return R
   */

  @PutMapping
  public R updateById(@RequestBody SysUser sysUser){
    return new R<>(sysUserService.updateById(sysUser));
  }

  /**
   * 通过id删除系统管理员表
   * @param userId id
   * @return R
   */

  @DeleteMapping("/{userId}")
  public R removeById(@PathVariable Long userId){
    return new R<>(sysUserService.removeById(userId));
  }

}
