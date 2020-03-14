package com.hdn.zp.service.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdn.zp.dao.CompanyMapper;
import com.hdn.zp.model.Company;
import com.hdn.zp.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 企业注册表
 *
 * @author hdn code generator
 * @date 2020-03-05 18:16:31
 */
@Service
@Slf4j
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);


    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> selectList(Company company) {
       return companyMapper.selectList(company);

    }

    @Override
    public int insertCompany(List<Company> company) {
        return companyMapper.insertCompany(company);

    }

    @Override
    public int updateCompany(List<Company> company) {
        return companyMapper.updateCompany(company);

    }

    @Override
    public int deleteCompany(long id) {
        return companyMapper.deleteCompany(id);

    }

}
