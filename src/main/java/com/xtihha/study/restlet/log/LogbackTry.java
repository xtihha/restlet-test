package com.xtihha.study.restlet.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
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

//        ContextListener listener = new ContextListener();
//        listener.contextInitialized(null);
//        listener.contextDestroyed(null);

        //需要确认resource文件夹的在classpath的路径，需要在pom.xml的build处设置
        logger.info(ClassLoader.getSystemResource("db/dump.xml").getPath());
    }

}
