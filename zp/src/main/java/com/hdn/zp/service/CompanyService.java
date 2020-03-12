package com.hdn.zp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdn.zp.model.Company;

import java.util.List;

/**
 * 企业注册表
 *
 * @author hdn code generator
 * @date 2020-03-05 18:16:31
 */
public interface CompanyService extends IService<Company> {

    public List<Company> selectAll();

}
