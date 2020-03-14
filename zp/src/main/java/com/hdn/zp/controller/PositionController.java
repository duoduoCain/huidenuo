package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.Position;
import com.hdn.zp.service.PositionService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 职位表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:46
 */
@RestController
@AllArgsConstructor
@RequestMapping("/position")
public class PositionController {

  private final PositionService positionService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param position 职位表
   * @return
   */
  @GetMapping("/page")
  public R getPositionPage(Page page, Position position) {
    return  new R<>(positionService.page(page,Wrappers.query(position)));
  }

  @GetMapping
  public List<Position>  getselectPosition(Position  position){
    return  positionService.selectList(position);
  }

  /**
   * 新增职位表
   * @param position 职位表
   * @return R
   */
  @PostMapping
   public int  getinsertPosition(List<Position>  position){
    return   positionService.insertPosition(position);
  }
  /**
   * 修改职位表
   * @param position 职位表
   * @return R
   */
  @PutMapping
   public  int  getupdatePosition(List<Position> position){
    return  positionService.updatePosition(position);
  }
  /**
   * 通过id删除职位表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public int  getdeletePosition(Long  id){
    return   positionService.deleteposition(id);
  }

}
