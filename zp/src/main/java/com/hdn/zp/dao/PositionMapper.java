package com.hdn.zp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.Position;
import com.hdn.zp.model.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:46
 */
public interface PositionMapper extends BaseMapper<Position> {

    public List<Position> selectList(@Param("position") Position position);

    public int  insertPosition(@Param("position") List<Position> position);

    public int  updatePosition(@Param("position") List<Position> position);

    public int  deleteposition(@Param("id") long id);

    /**
     * 查询热门城市
     */
    public List<Position>  selectHotCity(Long id);
}
