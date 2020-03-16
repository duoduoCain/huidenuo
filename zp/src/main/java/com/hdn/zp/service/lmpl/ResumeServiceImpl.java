package com.hdn.zp.service.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.ResumeMapper;
import com.hdn.zp.model.Resume;
import com.hdn.zp.service.ResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 简历表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:16
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    private   ResumeMapper  resumeMapper;
    @Override
    public List<Resume> selectList(Resume resume) {
        return resumeMapper.selectList(resume);
    }

    @Override
    public int insertResume(List<Resume> resume) {
        return resumeMapper.insertResume(resume);
    }

    @Override
    public int updateResume(List<Resume> resume) {
        return resumeMapper.updateResume(resume);
    }

    @Override
    public int deleteResume(Long id) {
        return resumeMapper.deleteResume(id);
    }

    @Override
    public List<Resume> selectLineResume(Long id) {
        return resumeMapper.selectLineResume(id);
    }

}
