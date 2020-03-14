package com.hdn.zp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdn.zp.model.SysRouteConf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 路由配置表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:14
 */
public interface SysRouteConfMapper extends BaseMapper<SysRouteConf> {

    public List<SysRouteConf>  selectList(@Param("sysRouteConf") SysRouteConf sysRouteConf);

}
