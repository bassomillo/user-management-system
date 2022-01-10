package com.bassomillo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<String> whiteName = Arrays.asList(request.getContextPath()+"/login.jsp",request.getContextPath()+"/register.jsp",
                request.getContextPath()+"/index.jsp");
        if(whiteName.contains(request.getRequestURI())){
            chain.doFilter(request,response);
        }else{
            HttpSession session = request.getSession();
            if(session.getAttribute("user")!=null){
                chain.doFilter(request,response);
            }else {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }
}
