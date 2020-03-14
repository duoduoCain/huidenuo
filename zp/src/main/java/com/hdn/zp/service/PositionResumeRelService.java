package com.hdn.zp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.PositionResumeRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位简历关联表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:18
 */
public interface PositionResumeRelService extends IService<PositionResumeRel> {

    public List<PositionResumeRel> selectList(@Param("positionResumeRel") PositionResumeRel positionResumeRel);

    public int insertPosition_ResumeRel(@Param("positionResumeRel") List<PositionResumeRel> positionResumeRel);

    public int updatePosition_ResumeRel(@Param("positionResumeRel") List<PositionResumeRel> positionResumeRel);

    public int deletePosition_ResumeRel(@Param("id") Long id);
}
