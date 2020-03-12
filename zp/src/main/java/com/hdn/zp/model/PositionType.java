package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 职位类别表
 *
 * @author pigx code generator
 * @date 2020-03-05 18:16:59
 */
@Data
@TableName("position_type")
@EqualsAndHashCode(callSuper = true)
public class PositionType extends Model<PositionType> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId
    private Integer id;
    /**
   * 职位类别名称
   */
    private String name;
    /**
   * 职位描述
   */
    private String describe;
    /**
   * 创建时间
   */
    private LocalDateTime createTime;
    /**
   * 修改时间
   */
    private LocalDateTime modifyTime;
  
}
