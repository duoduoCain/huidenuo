package com.hdn.zp.service.lmpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.PositionTypeMapper;
import com.hdn.zp.model.PositionType;
import com.hdn.zp.service.PositionTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职位类别表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:59
 */
@Service
public class PositionTypeServiceImpl extends ServiceImpl<PositionTypeMapper, PositionType> implements PositionTypeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);


    @Autowired
    private  PositionTypeMapper positionTypeMapper;
    @Override
    public List<PositionType> selectList(PositionType positionType) {
        return positionTypeMapper.selectList(positionType);
    }

    @Override
    public int insertPosition_type(List<PositionType> positionType) {
        return  positionTypeMapper.insertPosition_type(positionType);
    }

    @Override
    public int updatePosition_type(List<PositionType> positionType) {
        return positionTypeMapper.updatePosition_type(positionType);
    }

    @Override
    public int deletePosition_type(Long id) {
        return positionTypeMapper.deletePosition_type(id);
    }

}
