package com.xtihha.study.restlet.db.impl;

import org.apache.ibatis.session.SqlSession;

import com.xtihha.study.restlet.db.IStudentDao;
import com.xtihha.study.restlet.db.conf.SqlFactoryBuilder;
import com.xtihha.study.restlet.domain.Student;

/**
 * 
 * 
 * @author zhangxiaohu
 * @created 2013-7-14
 */

public class StudentDaoImpl implements IStudentDao {
    private SqlFactoryBuilder sqlFactoryBuilder;

    @Override
    public Student get(long id) {
        SqlSession session = sqlFactoryBuilder.getFactory().openSession();
        Student student = null;
        try {
            student = session.selectOne("restlet_service.student.getById", id);
        } finally {
            if (session != null)
                session.close();
        }
        return student;
    }

    public void setSqlFactoryBuilder(SqlFactoryBuilder sqlFactoryBuilder) {
        this.sqlFactoryBuilder = sqlFactoryBuilder;
    }

}
