package com.hdn.zp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.PositionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位类别表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:59
 */
public interface PositionTypeService extends IService<PositionType> {

    public List<PositionType> selectList(@Param("positionType") PositionType positionType);

    public int insertPosition_type(@Param("positionType") List<PositionType> positionType);

    public int updatePosition_type(@Param("positionType") List<PositionType> positionType);

    public int deletePosition_type(@Param("id") Long id);
}
