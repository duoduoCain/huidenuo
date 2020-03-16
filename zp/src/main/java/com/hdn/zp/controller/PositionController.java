package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.Position;
import com.hdn.zp.service.PositionService;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
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
     *
     * @param page     分页对象
     * @param position 职位表
     * @return
     */
    @GetMapping("/page")
    public R getPositionPage(Page page, Position position) {
        return new R<>(positionService.page(page, Wrappers.query(position)));
    }

    @RequestMapping(value = "getselectPosition", method = RequestMethod.GET)
    public R getselectPosition(Position position) {
        return R.ok(positionService.selectList(position));
    }

    /**
     * 新增职位表
     *
     * @param position 职位表
     * @return R
     */
    @RequestMapping(value = "getinsertPosition", method = RequestMethod.POST)
    public R getinsertPosition(@RequestBody Position position) {
        List<Position> list = new ArrayList<>();
        list.add(position);
        return R.ok(positionService.insertPosition(list));
    }
    /**
     * 新增职位表
     *
     * @param position 职位表(多个)
     * @return R
     */
    @RequestMapping(value = "publishJob", method = RequestMethod.POST)
    public R publishJob(@RequestBody List<Position> position) {
        for (Position  P:position){
            getinsertPosition(P);
        }
        return R.ok("成功");
    }


    /**
     * 修改职位表
     *
     * @param position 职位表(单个)
     * @return R
     */
    @RequestMapping(value = "getupdatePosition", method = RequestMethod.POST)
    public R getupdatePosition(@RequestBody Position position) {
        List<Position> list = new ArrayList();
        list.add(position);
        return R.ok(positionService.updatePosition(list));
    }

    /**
     * 修改职位表
     *
     * @param position 职位表(多个)
     * @return R
     */
    @RequestMapping(value = "getupdatemanyPosition", method = RequestMethod.POST)
    public R getupdatemanyPosition(@RequestBody List<Position> position) {
        for (Position S : position) {
            getupdatePosition(S);
        }

        return R.ok("成功");
    }

    /**
     * 通过id删除职位表
     *
     * @param id id
     * @return R
     */
    @RequestMapping(value = "getdeletePosition", method = RequestMethod.POST)
    public int getdeletePosition(Long id) {
        return positionService.deleteposition(id);
    }

    /***
     * 首页 ----查询热门岗位
     *
     */
    @RequestMapping(value = "getHostCity", method = RequestMethod.POST)
    public R getHostCity(Long id) {
        return R.ok(positionService.selectHotCity(id));
    }

}
