package com.hdn.zp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.PageBean;
import com.hdn.zp.model.Position;
import com.hdn.zp.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:46
 */
public interface PositionService extends IService<Position> {

    public List<Position> selectList(@Param("position") Position position);

    public int  insertPosition(@Param("position") List<Position> position);

    public int  updatePosition(@Param("position") List<Position> position);

    public int  deleteposition(@Param("id") long id);

    /**
     * 查询热门城市
     */
    public List<Position>  selectHotCity(PageBean  pageBean);

    public IPage<Position> selectPag(PageBean<Position> page, QueryWrapper<Position> wrapper);
}
