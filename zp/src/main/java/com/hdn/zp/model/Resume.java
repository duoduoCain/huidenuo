package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 简历表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:16
 */
@Data
@TableName("resume")
@EqualsAndHashCode(callSuper = true)
public class Resume extends Model<Resume> {
private static final long serialVersionUID = 1L;

    /**
   * 简历id
   */
    @TableId
    private Integer id;
    /**
   * 用户id
   */
    private Integer userId;
    /**
   * 姓名
   */
    private String resumeName;
    /**
   * 手机号
   */
    private String resumePhone;
    /**
   * 邮箱
   */
    private String resumeEmail;
    /**
   * 性别0男1女
   */
    private Integer sex;
    /**
   * 出生日期
   */
    private String birth;
    /**
   * 毕业院校
   */
    private String college;
    /**
   * 专业
   */
    private String major;
    /**
   * 学历
   */
    private String education;
    /**
   * 籍贯
   */
    private String location;
    /**
   * 求职岗位
   */
    private String job;
    /**
   * 薪资范围
   */
    private String salary;
    /**
   * 技术特长
   */
    private String technology;
    /**
   * 工作经历
   */
    private String experience;
    /**
   * 个人介绍
   */
    private String introducation;
  
}
