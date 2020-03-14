package com.hdn.zp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业注册表
 *
 * @author hdn code generator
 * @date 2020-03-05 18:16:31
 */
public interface CompanyService extends IService<Company> {

    public List<Company> selectList(@Param("company") Company company);

    public int insertCompany(@Param("company") List<Company> company);

    public int  updateCompany(@Param("company") List<Company> company);

    public int  deleteCompany(@Param("id") long id);

}
