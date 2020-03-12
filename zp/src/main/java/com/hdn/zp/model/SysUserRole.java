package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色表
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:46
 */
@Data
@TableName("sys_user_role")
@EqualsAndHashCode(callSuper = true)
public class SysUserRole extends Model<SysUserRole> {
private static final long serialVersionUID = 1L;

    /**
   * 用户ID
   */
    @TableId
    private Long userId;
    /**
   * 角色ID
   */
    private Integer roleId;
  
}
