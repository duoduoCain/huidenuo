package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.Resume;
import com.hdn.zp.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 简历表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

  private final  ResumeService resumeService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param resume 简历表
   * @return
   */
  @GetMapping("/page")
  public R getResumePage(Page page, Resume resume) {
    return  new R<>(resumeService.page(page,Wrappers.query(resume)));
  }


  @GetMapping
  public List<Resume> getselectListResume(Resume  resume){
    return resumeService.selectList(resume);
  }
  /**
   * 新增简历表
   * @param resume 简历表
   * @return R
   */
  @PostMapping
  public int getinsertResume(List<Resume> resume){
    return resumeService.insertResume(resume);
  }
  /**
   * 修改简历表
   * @param resume 简历表
   * @return R
   */
  @PutMapping
  public int getupdateResume(List<Resume> resume){
    return resumeService.updateResume(resume);
  }

  /**
   * 通过id删除简历表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public int getdeleteResume(Long  id){
    return resumeService.deleteResume(id);
  }
}
