package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.PositionResumeRel;
import com.hdn.zp.utils.R;
import com.hdn.zp.service.PositionResumeRelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

  @GetMapping
  public List<PositionResumeRel> getselectPositionResumeRel(PositionResumeRel  positionResumeRel){
    return  positionResumeRelService.selectList(positionResumeRel);
  }

  /**
   * 新增职位简历关联表
   * @param positionResumeRel 职位简历关联表
   * @return R
   */
  @PostMapping
  public int  getinsertPositionResumeRel(List<PositionResumeRel>  positionResumeRel){
    return   positionResumeRelService.insertPosition_ResumeRel(positionResumeRel);
  }
  /**
   * 修改职位简历关联表
   * @param positionResumeRel 职位简历关联表
   * @return R
   */
  @PutMapping
  public  int  getupdatePositionResumeRel(List<PositionResumeRel> positionResumeRel){
    return  positionResumeRelService.updatePosition_ResumeRel(positionResumeRel);
  }
  /**
   * 通过id删除职位简历关联表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public int  getdeletePositionResumeRel(Long  id){
    return   positionResumeRelService.deletePosition_ResumeRel(id);
  }

}
