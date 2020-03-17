package com.hdn.zp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.model.PageBean;
import com.hdn.zp.model.Position;
import com.hdn.zp.model.Region;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:46
 */
public interface PositionMapper extends BaseMapper<Position> {

    public List<Position> selectList(Position position);

    public int  insertPosition(List<Position> position);

    public int  updatePosition(List<Position> position);

    public int  deleteposition(Long id);

    /**
     * 查询热门城市
     */
//    public List<Position>  selectHotCity(PageBean pageBean);


    public IPage<Position> selectHotCity(Page<Position> positionPage);

}
