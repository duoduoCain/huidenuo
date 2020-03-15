package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.PositionResumeRel;
import com.hdn.zp.utils.DateUtils;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.PositionType;
import com.hdn.zp.service.PositionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
  @RequestMapping(value = "getselectPositionType",method = RequestMethod.GET)
  public R getselectPositionType(PositionType  positionType){
    return  R.ok(positionTypeService.selectList(positionType));
  }

  /**
   * 新增职位类别表
   * @param  positionType 职位类别表
   * @return R
   */
  @RequestMapping(value = "getinsertPositionType",method = RequestMethod.POST)
  public R  getinsertPositionType(@RequestBody PositionType  positionType){
    List<PositionType> list = new ArrayList<>();
    list.add(positionType);
    return   R.ok(positionTypeService.insertPosition_type(list));
  }
  /**
   * 修改职位类别表
   * @param positionType 职位类别表(单个)
   * @return R
   */
  @RequestMapping(value = "getupdatePositionType",method = RequestMethod.POST)
  public  R  getupdatePositionType(@RequestBody PositionType positionType){
    List<PositionType>   list =new ArrayList<>();
    list.add(positionType);
    return  R.ok(positionTypeService.updatePosition_type(list));
  }
  /**
   * 修改职位类别表
   * @param positionType 职位类别表(多个)
   * @return R
   */
  @RequestMapping(value = "getupdatemanyPositionType",method = RequestMethod.POST)
  public  R  getupdatemanyPositionType(@RequestBody List<PositionType> positionType){
      for (PositionType s: positionType){
        getupdatePositionType(s);
      }
      return R.ok("成功");
  }
  /**
   * 通过id删除职位类别表
   * @param id id
   * @return R
   */
  @RequestMapping(value = "getdeletePositionType",method = RequestMethod.POST)
  public int  getdeletePositionType(Long  id){
    return   positionTypeService.deletePosition_type(id);
  }

}
