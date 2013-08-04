package com.xtihha.study.restlet.manager.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: zhangxiaohu
 * Date: 13-8-4
 * Time: 上午11:34
 */
@Service("annotation2Manager")
public class Annotation2Manager {
    private static final Logger logger = LoggerFactory.getLogger(Annotation2Manager.class);
    private int counter = 0;

    public void hello2() {
        logger.info("this is in annotation2 manager");
        logger.info("counter is {}", ++counter);
    }
}
