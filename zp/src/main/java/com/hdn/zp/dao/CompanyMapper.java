package com.hdn.zp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.Company;

import java.util.List;

/**
 * 企业注册表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:31
 */
public interface CompanyMapper extends BaseMapper<Company> {

    public List<Company> selectList(Company company);

}
