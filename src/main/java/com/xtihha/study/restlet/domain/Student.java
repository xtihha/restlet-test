package com.xtihha.study.restlet.domain;

/**
 * 
 * @author zhangxiaohu
 * @created 2013-7-14
 */

public class Student {
    private long id;
    private String name;
    private String department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id).append(",");
        sb.append("name=").append(name).append(",");
        sb.append("department=").append(department);

        return sb.toString();
    }
}
