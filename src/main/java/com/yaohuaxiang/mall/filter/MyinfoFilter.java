package com.yaohuaxiang.mall.filter;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yaohuaxiang
 * @create 2020/9/25 - 11:44
 */

@WebFilter(filterName = "myFilter",urlPatterns = "/tomyinfo")
public class MyinfoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("user") == null){
            httpServletResponse.sendRedirect("tologin");
        }else{
            chain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
