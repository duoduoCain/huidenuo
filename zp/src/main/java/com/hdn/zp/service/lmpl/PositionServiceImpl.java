package com.hdn.zp.service.lmpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.PositionMapper;
import com.hdn.zp.model.PageBean;
import com.hdn.zp.model.Position;
import com.hdn.zp.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Position> selectHotCity(PageBean  pageBean) {
//        return positionMapper.selectHotCity(pageBean);
        return null;
    }


    @Override
    public IPage<Position> selectPag(PageBean<Position> page, QueryWrapper<Position> wrapper) {

        IPage<Position> page1 = positionMapper.selectPage(page, new QueryWrapper<>());
        return page1;
    }


}
