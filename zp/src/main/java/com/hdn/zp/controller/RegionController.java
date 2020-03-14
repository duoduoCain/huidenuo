package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.Region;
import com.hdn.zp.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 行政区域
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/region")
public class RegionController {

  private final  RegionService regionService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param region 行政区域
   * @return
   */
  @GetMapping("/page")
  public R getRegionPage(Page page, Region region) {
    return  new R<>(regionService.page(page,Wrappers.query(region)));
  }


  /**
   * 通过id查询行政区域
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Integer id){
    return new R<>(regionService.getById(id));
  }

  /**
   * 新增行政区域
   * @param region 行政区域
   * @return R
   */
  @PostMapping
  public R save(@RequestBody Region region){
    return new R<>(regionService.save(region));
  }

  /**
   * 修改行政区域
   * @param region 行政区域
   * @return R
   */
  @PutMapping
  public R updateById(@RequestBody Region region){
    return new R<>(regionService.updateById(region));
  }

  /**
   * 通过id删除行政区域
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Integer id){
    return new R<>(regionService.removeById(id));
  }

}
