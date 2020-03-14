package com.hdn.zp.service.lmpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.RegionMapper;
import com.hdn.zp.model.Region;
import com.hdn.zp.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行政区域
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:09
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);


    @Autowired
    private   RegionMapper  regionMapper;

    @Override
    public List<Region> selectList(Region region) {
        return regionMapper.selectList(region);
    }

    @Override
    public int insertRegion(List<Region> region) {
        return regionMapper.insertRegion(region);
    }

    @Override
    public int updateRegion(List<Region> region) {
        return regionMapper.updateRegion(region);
    }

    @Override
    public int deleteRegion(Long id) {
        return regionMapper.deleteRegion(id);
    }

}
