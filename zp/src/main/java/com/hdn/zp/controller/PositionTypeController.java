package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.PositionResumeRel;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.PositionType;
import com.hdn.zp.service.PositionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
  @GetMapping
  public List<PositionType> getselectPositionType(PositionType  positionType){
    return  positionTypeService.selectList(positionType);
  }

  /**
   * 新增职位类别表
   * @param  positionType 职位类别表
   * @return R
   */
  @PostMapping
  public int  getinsertPositionType(List<PositionType>  positionType){
    return   positionTypeService.insertPosition_type(positionType);
  }
  /**
   * 修改职位类别表
   * @param positionType 职位类别表
   * @return R
   */
  @PutMapping
  public  int  getupdatePositionType(List<PositionType> positionType){
    return  positionTypeService.updatePosition_type(positionType);
  }
  /**
   * 通过id删除职位类别表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public int  getdeletePositionType(Long  id){
    return   positionTypeService.deletePosition_type(id);
  }

}
