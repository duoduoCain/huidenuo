package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 职位表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:46
 */
@Data
@TableName("position")
@EqualsAndHashCode(callSuper = true)
public class Position extends Model<Position> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId
    private Integer id;
    /**
   * 职位名称
   */
    private String name;
    /**
   * 职位类别
   */
    private Integer typeid;
    /**
   * 职位描述
   */
    private String describe;
    /**
   * 专业要求
   */
    private String major;
    /**
   * 学历要求
   */
    private String education;
    /**
   * 工作地区
   */
    private String jobcity;
    /**
   * 招聘数量
   */
    private Integer jobnumber;
    /**
   * 薪酬范围
   */
    private String salary;
    /**
   * 性别要求0男1女
   */
    private Integer sex;
    /**
   * 最小年龄
   */
    private Integer minage;
    /**
   * 最大年龄
   */
    private Integer maxage;
    /**
   * 联系人
   */
    private String contact;
    /**
   * 联系电话
   */
    private String phone;
    /**
   * 联系邮箱
   */
    private String email;
    /**
   * 发布人
   */
    private Integer publisher;
    /**
   * 发布时间
   */
    private Date pubdate;
    /**
   * 状态：0关闭1招聘中2重新打开
   */
    private Integer status;
    /**
   * 创建时间
   */
    private Date createTime;
    /**
   * 修改时间
   */
    private Date modifyTime;
  
}
