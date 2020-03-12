package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.Resume;
import com.hdn.zp.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 简历表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

  private final  ResumeService resumeService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param resume 简历表
   * @return
   */
  @GetMapping("/page")
  public R getResumePage(Page page, Resume resume) {
    return  new R<>(resumeService.page(page,Wrappers.query(resume)));
  }


  /**
   * 通过id查询简历表
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Integer id){
    return new R<>(resumeService.getById(id));
  }

  /**
   * 新增简历表
   * @param resume 简历表
   * @return R
   */
  @PostMapping
  public R save(@RequestBody Resume resume){
    return new R<>(resumeService.save(resume));
  }

  /**
   * 修改简历表
   * @param resume 简历表
   * @return R
   */
  @PutMapping
  public R updateById(@RequestBody Resume resume){
    return new R<>(resumeService.updateById(resume));
  }

  /**
   * 通过id删除简历表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Integer id){
    return new R<>(resumeService.removeById(id));
  }

}
