package com.xtihha.study.restlet.resource;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtihha.study.restlet.db.IStudentDao;
import com.xtihha.study.restlet.domain.Student;

/**
 * 
 * 
 * @author zhangxiaohu
 * @created 2013-7-14
 */

public class StudentResource extends ServerResource {

    // TODO use dao manager
    private IStudentDao studentDao;

    private static final Logger logger = LoggerFactory.getLogger(StudentResource.class);

    @Get
    public Representation get() {
        String idStr = (String) getRequest().getAttributes().get("id");
        long id = Long.parseLong(idStr);
        Student student = studentDao.get(id);

        String value = new StringBuilder().append("{").append("\"data\":{").append("\"id\":")
                .append(student.getId()).append(",").append("\"name\":").append("\"")
                .append(student.getName()).append("\"").append(",").append("\"department\":")
                .append(student.getDepartment()).append("\"").append("}").append("}").toString();

        logger.info(value);

        JsonRepresentation ret = new JsonRepresentation(value);
        return ret;
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

}
