package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 路由配置表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:14
 */
@Data
@TableName("sys_route_conf")
@EqualsAndHashCode(callSuper = true)
public class SysRouteConf extends Model<SysRouteConf> {
private static final long serialVersionUID = 1L;

    /**
   * 主键
   */
    @TableId
    private Long id;
    /**
   * 路由名称
   */
    private String routeName;
    /**
   * 路由ID
   */
    private String routeId;
    /**
   * 断言
   */
    private String predicates;
    /**
   * 过滤器
   */
    private String filters;
    /**
   * 
   */
    private String uri;
    /**
   * 排序
   */
    private Integer order;
    /**
   * 创建时间
   */
    private LocalDateTime createTime;
    /**
   * 修改时间
   */
    private LocalDateTime updateTime;
    /**
   * 删除标记
   */
    private String delFlag;
  
}
