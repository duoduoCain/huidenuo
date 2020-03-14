package com.hdn.zp.service.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.PositionMapper;
import com.hdn.zp.model.Position;
import com.hdn.zp.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职位表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:46
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> selectList(Position position) {
        return positionMapper.selectList(position);
    }

    @Override
    public int insertPosition(List<Position> position) {
        return positionMapper.insertPosition(position);
    }

    @Override
    public int updatePosition(List<Position> position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public int deleteposition(long id) {
        return positionMapper.deleteposition(id);
    }

}
