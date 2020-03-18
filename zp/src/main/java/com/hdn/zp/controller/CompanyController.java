package com.hdn.zp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdn.zp.common.BaseController;
import com.hdn.zp.model.Company;
import com.hdn.zp.service.CompanyService;
import com.hdn.zp.utils.DateUtils;
import com.hdn.zp.utils.R;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 企业注册表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private final CompanyService companyService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param company 企业注册表
   * @return
   */
  @RequestMapping(value = "page",method = RequestMethod.GET)
  public R getCompanyPage(Page page, Company company) {
     page.setSize(1);
     page.setTotal(10);
    return  new R<>(companyService.page(page,Wrappers.query(company)));
  }

    /**
     * 查询企业注册表中数据
     * @param company
     * @return
     */
  @RequestMapping(value = "getselectList",method = RequestMethod.GET)
  public List<Company>  getselectList(Company company){
   return companyService.selectList(company);

  }
  /**
   * 新增企业注册表
   * @param company 企业注册表
   * @return R
   */
  @RequestMapping(value = "getinsertCompany",method = RequestMethod.POST)
   public R  getinsertCompany(@RequestBody Company  company){
      List<Company>  list  = new ArrayList<>();
      list.add(company);
    return R.ok(companyService.insertCompany(list));
  }
  /**
   * 修改企业注册表
   * @param company 企业注册表(单个)
   * @return R
   */
  @RequestMapping(value = "getupdateCompany",method = RequestMethod.POST)
  public   R  getupdateCompany(@RequestBody Company company){
      List<Company>  list  = new ArrayList<>();
    /*  company.setModifyTime(DateUtils.getNowDate());*/
      list.add(company);
    return  R.ok(companyService.updateCompany(list));
  }
    /**
     * 修改企业注册表
     * @param company 企业注册表(多个)
     * @return R
     */
    @RequestMapping(value = "getupdatemanyCompany",method = RequestMethod.POST)
    public   R  getupdatemanyCompany(@RequestBody List<Company> company){
        for(Company S:company){
            getupdateCompany(S);
        }

        return  R.ok("成功");
    }

  /**
   * 通过id删除企业注册表
   * @param id id
   * @return R
   */

  @RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
  public  R  getdeleteCompany(Long  id){
    companyService.deleteCompany(id);
    return R.ok("成功");
  }
}
