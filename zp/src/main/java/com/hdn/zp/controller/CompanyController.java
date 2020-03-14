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

  /*  @PostMapping("insertCompany")
    public int insertCompany(@RequestBody Company   company){
        List<Company> list = new ArrayList<>();
        list.add(company);
        return companyService.insertCompany(list);
    }*/

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
   public int  getinsertCompany(@RequestBody Company  company){
      List<Company>  list  = new ArrayList<>();
      list.add(company);
    return companyService.insertCompany(list);
  }
  /**
   * 修改企业注册表
   * @param company 企业注册表
   * @return R
   */
  //这里要加请求路径
  //批量更新做一个  单个更新做一个借口
  @PutMapping
  public   int  getupdateCompany(List<Company> company){
      //更新的时候吧时间也更新了

    //  DateUtils.getNowDateOnly();//这个可以获取当前时间
      //时间格式是YYYY_MM_DD
    //  DateUtils.getNowDate();//这个是获取 YYYY_MM_DD HH:MM:ss
    return  companyService.updateCompany(company);
  }


  /**
   * 通过id删除企业注册表
   * @param id id
   * @return R
   */
  //删除借口可以不做  这里加上标识的路径
  @DeleteMapping("/delete/{id}")
  public  int  getdeleteCompany(Long  id){
    return  companyService.deleteCompany(id);
  }
}
