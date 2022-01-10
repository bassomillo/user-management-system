package com.bassomillo.listener;

import com.bassomillo.constant.Constant;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        Constant.SALT = servletContext.getInitParameter("SALT");
        Constant.BASE_PATH = servletContext.getInitParameter("BASE_PATH");
        Constant.BASE_URL_PATH = servletContext.getInitParameter("BASE_URL_PATH");
    }
}
