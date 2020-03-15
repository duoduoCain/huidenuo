package com.hdn.zp.vo;

import com.hdn.zp.utils.Contants;
import com.hdn.zp.utils.ServletUtils;

/**
 * Created by 多多啦 on 2020/3/15 0015.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(Contants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(Contants.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Contants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Contants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest() {
        return getPageDomain();
    }
}
