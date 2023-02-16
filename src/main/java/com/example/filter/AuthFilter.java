package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebFilter("/user/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Object user = httpServletRequest.getSession().getAttribute("user");

        if (user == null) {
            ((HttpServletResponse) response).sendRedirect("/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        /*
         * Called before the Filter instance is removed from service by the web
         * container
         */
    }
    //write your code here!
}