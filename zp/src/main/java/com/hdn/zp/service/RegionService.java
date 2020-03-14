package com.hdn.zp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 行政区域
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:09
 */
public interface RegionService extends IService<Region> {

    public List<Region> selectList(@Param("region") Region region);

    public int insertRegion(@Param("region") List<Region> region);

    public int updateRegion(@Param("region") List<Region> region);

    public int deleteRegion(@Param("id") Long id);
}
