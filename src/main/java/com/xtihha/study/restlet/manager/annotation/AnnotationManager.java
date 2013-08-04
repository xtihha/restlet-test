package com.xtihha.study.restlet.manager.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * User: zhangxiaohu
 * Date: 13-8-4
 * Time: 上午11:11
 */
public class AnnotationManager {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationManager.class);

    public void hello() {
        logger.info("This is annotation manager");
    }

    @PostConstruct
    public void postContruct() {
        logger.info("this is annotion manager's post construct");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("this is annotion manager's pre destroy");
    }
}
