package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.utils.R;
import com.hdn.zp.model.Resume;
import com.hdn.zp.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    private final ResumeService resumeService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param resume 简历表
     * @return
     */
    @GetMapping("/page")
    public R getResumePage(Page page, Resume resume) {
        return new R<>(resumeService.page(page, Wrappers.query(resume)));
    }


    @RequestMapping(value = "getselectListResume", method = RequestMethod.GET)
    public R getselectListResume(Resume resume) {
        return R.ok(resumeService.selectList(resume));
    }

    /**
     * 新增简历表
     *
     * @param resume 简历表
     * @return R
     */
    @RequestMapping(value = "getinsertResume", method = RequestMethod.POST)
    public R getinsertResume(@RequestBody Resume resume) {
        List<Resume> list = new ArrayList<>();
        list.add(resume);
        return R.ok(resumeService.insertResume(list));
    }

    /**
     * 修改简历表
     *
     * @param resume 简历表(单个)
     * @return R
     */
    @RequestMapping(value = "getupdateResume",method = RequestMethod.POST)
    public R getupdateResume(@RequestBody Resume  resume) {
        List<Resume>  list  = new ArrayList<>();
        list.add(resume);
        return R.ok(resumeService.updateResume(list));
    }
    /**
     * 修改简历表
     *
     * @param resume 简历表(多个个)
     * @return R
     */
    @RequestMapping(value = "getupdatemanyResume",method = RequestMethod.POST)
    public R getupdatemanyResume(@RequestBody List<Resume>  resume) {
       for (Resume r: resume){
           getupdateResume(r);
       }
        return R.ok("成功");
    }
    /**
     * 通过id删除简历表
     *
     * @param id id
     * @return R
     */
    @RequestMapping(value = "getdeleteResume",method = RequestMethod.POST)
    public int getdeleteResume(Long id) {
        return resumeService.deleteResume(id);
    }
    /**
     *
     * 查看在线简历--我的(已经对简历编辑的情况下)
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public  R   getmylineResume(Long id){
        return R.ok(resumeService.selectLineResume(id));
    }
}
