package com.hdn.zp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.PositionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位类别表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:59
 */
public interface PositionTypeMapper extends BaseMapper<PositionType> {

    public List<PositionType> selectList(@Param("positionType") PositionType positionType);

    public int insertPosition_type(@Param("positionType") List<PositionType> positionType);

    public int updatePosition_type(@Param("positionType") List<PositionType> positionType);

    public int deletePosition_type(@Param("id") Long id);

}
