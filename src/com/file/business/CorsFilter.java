package com.file.business;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest,  ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		 
        // 判断是否是http请求  
        if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {  
            throw new ServletException(  
                    "OncePerRequestFilter just supports HTTP requests");  
        }  
        // 获得在下面代码中要用的request,response,session对象  
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;  
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;  

        // 跨域
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
//        String origin = httpRequest.getHeader("Origin");
//        if (origin != null) {
//            httpResponse.addHeader("Access-Control-Allow-Origin", origin);
//        }
//        httpResponse.addHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept,X-Cookie");  
        httpResponse.addHeader("Access-Control-Allow-Headers", "x-requested-with,Cache-Control,Pragma,Content-Type,Token");  
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");  
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");  
        if ( httpRequest.getMethod().equals("OPTIONS") ) {  
            httpResponse.setStatus(HttpServletResponse.SC_OK);  
            return;  
        }  
        filterChain.doFilter(servletRequest, servletResponse);  
	}

	@Override
	public void destroy() {
		
	}

}
