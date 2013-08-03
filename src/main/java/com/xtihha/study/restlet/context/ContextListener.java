package com.xtihha.study.restlet.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Enumeration;

public class ContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        Enumeration<String> params = sc.getInitParameterNames();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            logger.info("{} --> {}", param, sc.getInitParameter(param));
        }
        logger.debug("Context initizlized at " + new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed at " + new Date());
    }

}
