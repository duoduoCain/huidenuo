package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.SysRouteConf;
import com.hdn.zp.service.SysRouteConfService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 路由配置表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysrouteconf")
public class SysRouteConfController {

  private final SysRouteConfService sysRouteConfService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param sysRouteConf 路由配置表
   * @return
   */
  @GetMapping("/page")
  public R getSysRouteConfPage(Page page, SysRouteConf sysRouteConf) {
    return  new R<>(sysRouteConfService.page(page,Wrappers.query(sysRouteConf)));
  }


  /**
   * 通过id查询路由配置表
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(sysRouteConfService.getById(id));
  }

  /**
   * 新增路由配置表
   * @param sysRouteConf 路由配置表
   * @return R
   */

  @PostMapping
  public R save(@RequestBody SysRouteConf sysRouteConf){
    return new R<>(sysRouteConfService.save(sysRouteConf));
  }

  /**
   * 修改路由配置表
   * @param sysRouteConf 路由配置表
   * @return R
   */

  @PutMapping
  public R updateById(@RequestBody SysRouteConf sysRouteConf){
    return new R<>(sysRouteConfService.updateById(sysRouteConf));
  }

  /**
   * 通过id删除路由配置表
   * @param id id
   * @return R
   */

  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Long id){
    return new R<>(sysRouteConfService.removeById(id));
  }

}
