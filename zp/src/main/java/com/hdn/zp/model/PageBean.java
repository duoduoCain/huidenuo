package com.hdn.zp.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageBean<T> extends Page<T> implements Serializable {
     public  Integer  pageNo;
     public  Integer  pageSize;
     public PageBean(long current,long size){
          super(current,size);
     }
}
