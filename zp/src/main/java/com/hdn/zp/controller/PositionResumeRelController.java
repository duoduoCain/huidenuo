package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.PositionResumeRel;
import com.hdn.zp.utils.R;
import com.hdn.zp.service.PositionResumeRelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 职位简历关联表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/positionresumerel")
public class PositionResumeRelController {

  private final  PositionResumeRelService positionResumeRelService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param positionResumeRel 职位简历关联表
   * @return
   */
  @GetMapping("/page")
  public R getPositionResumeRelPage(Page page, PositionResumeRel positionResumeRel) {
    return  new R<>(positionResumeRelService.page(page,Wrappers.query(positionResumeRel)));
  }


  /**
   * 通过id查询职位简历关联表
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Integer id){
    return new R<>(positionResumeRelService.getById(id));
  }

  /**
   * 新增职位简历关联表
   * @param positionResumeRel 职位简历关联表
   * @return R
   */
  @PostMapping
  public R save(@RequestBody PositionResumeRel positionResumeRel){
    return new R<>(positionResumeRelService.save(positionResumeRel));
  }

  /**
   * 修改职位简历关联表
   * @param positionResumeRel 职位简历关联表
   * @return R
   */
  @PutMapping
  public R updateById(@RequestBody PositionResumeRel positionResumeRel){
    return new R<>(positionResumeRelService.updateById(positionResumeRel));
  }

  /**
   * 通过id删除职位简历关联表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Integer id){
    return new R<>(positionResumeRelService.removeById(id));
  }

}
