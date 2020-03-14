package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.PositionType;
import com.hdn.zp.service.PositionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 职位类别表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:59
 */
@RestController
@AllArgsConstructor
@RequestMapping("/positiontype")
public class PositionTypeController {

  private final  PositionTypeService positionTypeService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param positionType 职位类别表
   * @return
   */
  @GetMapping("/page")
  public R getPositionTypePage(Page page, PositionType positionType) {
    return  new R<>(positionTypeService.page(page,Wrappers.query(positionType)));
  }


  /**
   * 通过id查询职位类别表
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Integer id){
    return new R<>(positionTypeService.getById(id));
  }

  /**
   * 新增职位类别表
   * @param positionType 职位类别表
   * @return R
   */
  @PostMapping
  public R save(@RequestBody PositionType positionType){
    return new R<>(positionTypeService.save(positionType));
  }

  /**
   * 修改职位类别表
   * @param positionType 职位类别表
   * @return R
   */
  @PutMapping
  public R updateById(@RequestBody PositionType positionType){
    return new R<>(positionTypeService.updateById(positionType));
  }

  /**
   * 通过id删除职位类别表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Integer id){
    return new R<>(positionTypeService.removeById(id));
  }

}
