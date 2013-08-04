package com.xtihha.study.restlet.manager.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * User: zhangxiaohu
 * Date: 13-8-4
 * Time: 下午1:56
 */
public class AnnotationManagerTest {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationManagerTest.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-mvc-config.xml");
        AnnotationManager mgr = (AnnotationManager) ctx.getBean("annotationManager");
        mgr.hello();

        //通过annotation查找
        Annotation2Manager mgr2 = (Annotation2Manager) ctx.getBean("annotation2Manager");
        mgr2.hello2();
    }
}
