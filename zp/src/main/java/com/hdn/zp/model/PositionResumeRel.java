package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 职位简历关联表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:18
 */
@Data
@TableName("position_resume_rel")
@EqualsAndHashCode(callSuper = true)
public class PositionResumeRel extends Model<PositionResumeRel> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId
    private Integer id;
    /**
   * 
   */
    private Integer positionid;
    /**
   * 
   */
    private Integer resumeid;
    /**
   * 投递报名时间
   */
    private LocalDateTime tddate;
    /**
   * 状态：1已报名0取消
   */
    private Integer status;
    /**
   * 创建时间
   */
    private LocalDateTime createTime;
    /**
   * 修改时间
   */
    private LocalDateTime modifyTime;
  
}
