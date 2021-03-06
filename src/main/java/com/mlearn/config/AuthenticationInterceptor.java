package com.mlearn.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rezero
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        logger.info(request.getRequestURL());
        logger.info(handler.toString());

        if (request.getSession().getAttribute("user") == null){
            response.sendRedirect("/login.html");
            return false;
        }

        return true;
    }
}
