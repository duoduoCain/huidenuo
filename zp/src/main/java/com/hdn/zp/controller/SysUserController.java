package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.common.BaseController;
import com.hdn.zp.model.SysUser;
import com.hdn.zp.service.SysUserService;
import com.hdn.zp.utils.Contants;
import com.hdn.zp.utils.R;
import com.hdn.zp.utils.RedisUtils;
import com.hdn.zp.utils.ServletUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 系统管理员表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:32
 */
@RestController
@RequestMapping("/sysuser")
@Slf4j
public class SysUserController extends BaseController {

  @Autowired
  private  SysUserService sysUserService;
  @Resource
  private RedisUtils redisUtils;

  /**
   * 注册，跨域使用的
   */
  @GetMapping("register") // 跨域使用的
  public R registGet(SysUser sysUser) {
    return doRegister(sysUser);
  }

  private R doRegister(SysUser sysUser) {
    try {
      return sysUserService.registerMcUser(sysUser);
    } catch (Exception e) {
      log.error("注册异常:", e);
      return R.error("系统繁忙,请稍后再试");
    }
  }


  @GetMapping("login")
  public R login(SysUser sysUser){
    //判断是否登陆了
    sysUser.setPhone("asdf");
    redisUtils.set(Contants.TOKEN+"_"+sysUser.getPhone(),sysUser,3600);
//    String header = ServletUtils.getRequest().getHeader(Contants.ACCESS_TOKEN);

//    ServletUtils.getRequest().

    return R.ok();
  }

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
