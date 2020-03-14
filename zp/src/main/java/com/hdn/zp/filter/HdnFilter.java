package com.hdn.zp.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdn.zp.common.BusinessException;
import com.hdn.zp.utils.Contants;
import com.hdn.zp.utils.R;
import com.hdn.zp.utils.ServletUtils;
import com.hdn.zp.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 多多啦 on 2020/3/12 0012.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */
@WebFilter(urlPatterns = "/*",filterName = "hdnFilter")
@Slf4j
public class HdnFilter implements Filter {

    private List<String> list =new ArrayList<String>();

    public HdnFilter(){
        super();
        list.add("/hdn/sysuser/register");
        list.add("/hdn/sysuser/login");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String contextPath = req.getContextPath();
        String requestURI = req.getRequestURI();
        log.debug("当前登陆的url是"+requestURI);
        if(list.contains(requestURI)){
            log.debug("系统白名单"+requestURI);
        }
        filterChain.doFilter(servletRequest,servletResponse);
//        String header = req.getHeader(Contants.TOKEN);
//        if(StringUtils.isBlank(header)){
//            servletResponse.setContentType("application/json; charset=utf-8");
//            servletResponse.setCharacterEncoding("UTF-8");
//            R<String> r = new R<>();
//            r.setMsg("token失效");
//            log.error("token失效");
//            String userJson = convertObjectToJson(r);
//            OutputStream out = servletResponse.getOutputStream();
//            out.write(userJson.getBytes("UTF-8"));
//            out.flush();
//            return;
//        }
        //没有redis 做token缓存有点困难  打算做成数据库形式的


       // filterChain.doFilter(servletRequest, servletResponse);

    }
    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Override
    public void destroy() {

    }
}
