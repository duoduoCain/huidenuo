package com.hdn.zp.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 行政区域
 *
 * @author pigx code generator
 * @date 2020-03-05 18:17:09
 */
@Data
@TableName("region")
@EqualsAndHashCode(callSuper = true)
public class Region extends Model<Region> {
private static final long serialVersionUID = 1L;

    /**
   * 
   */
    @TableId
    private Integer id;
    /**
   * 编码
   */
    private String code;
    /**
   * 名称
   */
    private String name;
    /**
   * 区域级别(1-省级, 2-城市, 3-区县)
   */
    private String level;
    /**
   * 上级区域
   */
    private Integer parentId;
    /**
   * 排序号
   */
    private Integer sortNumber;
    /**
   * 路径
   */
    private String path;
    /**
   * 简称
   */
    private String abbr;
    /**
   * 拼音缩写
   */
    private String spelling;
    /**
   * 拼音
   */
    private String shortSpelling;
    /**
   * 创建者
   */
    private String creator;
    /**
   * 
   */
    private LocalDateTime createTime;
    /**
   * 
   */
    private LocalDateTime updateTime;
    /**
   * 修改者
   */
    private String modifier;
  
}
