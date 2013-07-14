package com.xtihha.study.restlet.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.xtihha.study.restlet.db.IStudentDao;
import com.xtihha.study.restlet.domain.Student;

/**
 * 
 * 
 * @author zhangxiaohu
 * @created 2013-7-14
 */

public class ServiceManager implements InitializingBean {
    private IStudentDao studentDao;

    private static final Logger logger = LoggerFactory.getLogger(ServiceManager.class);

    @Override
    public void afterPropertiesSet() {
        logger.info("{} has been initialized", ServiceManager.class);
    }

    public Student getStudent(long id) {
        return studentDao.get(id);
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

}
