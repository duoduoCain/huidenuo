package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统管理员表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:32
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends Model<SysUser> {
private static final long serialVersionUID = 1L;

    /**
   * 主键ID
   */
    @TableId
    private Long userId;
    /**
   * 用户名
   */
    private String username;
    /**
   * 密码
   */
    private String password;
    /**
   * 随机盐
   */
    private String salt;
    /**
   * 电话
   */
    private String phone;
    /**
   * 头像
   */
    private String avatar;
    /**
   * 部门ID
   */
    private Integer deptId;
    /**
   * 创建时间
   */
    private LocalDateTime createTime;
    /**
   * 修改时间
   */
    private LocalDateTime updateTime;
    /**
   * 0-正常，9-锁定
   */
    private String lockFlag;
    /**
   * 0-正常，1-删除
   */
    private String delFlag;
    /**
   * 微信openid
   */
    private String wxOpenid;
    /**
   * QQ openid
   */
    private String qqOpenid;
    /**
   * 所属租户
   */
    private Integer tenantId;
  
}
