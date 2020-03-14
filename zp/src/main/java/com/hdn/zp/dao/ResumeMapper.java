package com.hdn.zp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 简历表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:16
 */
public interface ResumeMapper extends BaseMapper<Resume> {

    public List<Resume> selectList(@Param("resume") Resume resume);

    public int insertResume(@Param("resume") List<Resume> resume);

    public int updateResume(@Param("resume") List<Resume> resume);

    public int deleteResume(@Param("id") Long id);

}
