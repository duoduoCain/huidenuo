package com.hdn.zp.service.lmpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.PositionResumeRelMapper;
import com.hdn.zp.model.PositionResumeRel;
import com.hdn.zp.service.PositionResumeRelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职位简历关联表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:18
 */
@Service
public class PositionResumeRelServiceImpl extends ServiceImpl<PositionResumeRelMapper, PositionResumeRel> implements PositionResumeRelService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private  PositionResumeRelMapper positionResumeRelMapper;
    @Override
    public List<PositionResumeRel> selectList(PositionResumeRel positionResumeRel) {
        return positionResumeRelMapper.selectList(positionResumeRel);
    }

    @Override
    public int insertPosition_ResumeRel(List<PositionResumeRel> positionResumeRel) {
        return positionResumeRelMapper.insertPosition_ResumeRel(positionResumeRel);
    }

    @Override
    public int updatePosition_ResumeRel(List<PositionResumeRel> positionResumeRel) {
        return positionResumeRelMapper.updatePosition_ResumeRel(positionResumeRel);
    }

    @Override
    public int deletePosition_ResumeRel(Long id) {
        return positionResumeRelMapper.deletePosition_ResumeRel(id);
    }

}
