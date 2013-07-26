package com.xtihha.study.restlet.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtihha.study.restlet.context.ContextListener;

/**
 * 
 * @author zhangxiaohu
 * @created 2013-7-13
 */

public class LogbackTry {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTry.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

        ContextListener listener = new ContextListener();
        listener.contextInitialized(null);
        listener.contextDestroyed(null);

        logger.info(ClassLoader.getSystemResource("db/dump.xml").getPath());
    }

}
