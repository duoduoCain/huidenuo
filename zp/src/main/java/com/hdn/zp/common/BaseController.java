package com.hdn.zp.common;

import com.hdn.zp.utils.ServletUtils;
import com.hdn.zp.utils.SqlUtil;
import com.hdn.zp.vo.PageDomain;
import com.hdn.zp.vo.TableSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.hdn.zp.utils.SqlUtil.*;

/**
 * Created by 多多啦 on 2020/3/12 0012.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
public class BaseController {

    /**
     * 获取request
     */
    public HttpServletRequest getRequest() {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

}
