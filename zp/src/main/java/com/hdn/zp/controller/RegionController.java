package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.Position;
import com.hdn.zp.model.PositionType;
import com.hdn.zp.utils.DateUtils;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.Region;
import com.hdn.zp.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

  @RequestMapping(value = "getselectListRegion",method = RequestMethod.GET)
  public R  getselectListRegion(Region  region){
    return R.ok(regionService.selectList(region));
  }
  /**
   * 新增行政区域
   * @param region 行政区域
   * @return R
   */
  @RequestMapping(value = "getinsertRegion",method = RequestMethod.POST)
  public R  getinsertRegion(@RequestBody Region region){
    List<Region>  list =new ArrayList<>();
    list.add(region);
    return   R.ok(regionService.insertRegion(list));
  }

  /**
   * 修改行政区域
   * @param region 行政区域(单个)
   * @return R
   */
  @RequestMapping(value = "getupdateRegion",method = RequestMethod.POST)
  public R  getupdateRegion(@RequestBody Region region){
    List<Region>  list  =new ArrayList<>();
    list.add(region);
    return   R.ok(regionService.updateRegion(list));
  }
  /**
   * 修改行政区域
   * @param region 行政区域(多个)
   * @return R
   */
  @RequestMapping(value = "getupdatemanyRegion",method = RequestMethod.POST)
  public R  getupdatemanyRegion(@RequestBody List<Region>  region){
      for (Region P: region){
        getupdateRegion(P);
      }
      return R.ok("成功");
  }
  /**
   * 通过id删除行政区域
   * @param id id
   * @return R
   */
  @RequestMapping(value = "getdeleteRegion",method = RequestMethod.POST)
  public int  getdeleteRegion(Long id){
    return   regionService.deleteRegion(id);
  }
}
