package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.common.BaseController;
import com.hdn.zp.model.Company;
import com.hdn.zp.service.CompanyService;
import com.hdn.zp.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 企业注册表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private final CompanyService companyService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param company 企业注册表
   * @return
   */
  @GetMapping("/page")
  public R getCompanyPage(Page page, Company company) {
    return  new R<>(companyService.page(page,Wrappers.query(company)));
  }

  @GetMapping("/list")
  public R getCompanyPageList(Page page, Company company) {
    return  new R<>(companyService.selectAll(company));
  }


  /**
   * 通过id查询企业注册表
   * @param id id
   * @return R
   */
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Integer id){
    return new R<>(companyService.getById(id));
  }

  /**
   * 新增企业注册表
   * @param company 企业注册表
   * @return R
   */
  @PostMapping
  public R save(@RequestBody Company company){
    return new R<>(companyService.save(company));
  }

  /**
   * 修改企业注册表
   * @param company 企业注册表
   * @return R
   */
  @PutMapping
  public R updateById(@RequestBody Company company){
    return new R<>(companyService.updateById(company));
  }

  /**
   * 通过id删除企业注册表
   * @param id id
   * @return R
   */
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Integer id){
    return new R<>(companyService.removeById(id));
  }

}
