package com.hdn.zp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 行政区域
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:09
 */
public interface RegionMapper extends BaseMapper<Region> {

    public List<Region> selectList( Region region);

    public int insertRegion( List<Region> region);

    public int updateRegion( List<Region> region);

    public int deleteRegion( Long id);

}
