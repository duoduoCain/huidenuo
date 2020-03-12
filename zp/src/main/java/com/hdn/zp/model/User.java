package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author pigx code generator
 * @date 2020-03-10 10:30:06
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = true)
public class User extends Model<User> {
private static final long serialVersionUID = 1L;

    /**
   * 用户id
   */
    @TableId
    private Integer id;
    /**
   * 用户名
   */
    private String username;
    /**
   * 密码
   */
    private String password;
    /**
   * 电话
   */
    private String telphone;
    /**
   * 邮箱
   */
    private String email;
    /**
   * 微信
   */
    private String wx;
    /**
   * 状态：0未 1已注册
   */
    private String status;
    /**
   * 注册时间
   */
    private LocalDateTime regTime;
    /**
   * 创建时间
   */
    private LocalDateTime createTime;
    /**
   * 修改时间
   */
    private LocalDateTime modifyTime;
  
}
