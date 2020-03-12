package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 企业注册表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:31
 */
@Data
@TableName("company")
@EqualsAndHashCode(callSuper = true)
public class Company extends Model<Company> {
private static final long serialVersionUID = 1L;

    /**
   * 企业用户id
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
   * 用户注册时间
   */
    private Date regTime;
    /**
   * 公司名称
   */
    private String companyname;
    /**
   * 所在地区
   */
    private String area;
    /**
   * 公司性质
   */
    private String companyproperty;
    /**
   * 公司介绍
   */
    private String describe;
    /**
   * 营业执照图片
   */
    private String yyzz;
    /**
   * 联系人
   */
    private String contact;
    /**
   * 联系电话
   */
    private String phone;
    /**
   * 公司地址
   */
    private String address;
    /**
   * 创建时间
   */
    private Date createTime;
    /**
   * 修改时间
   */
    private Date modifyTime;

}
