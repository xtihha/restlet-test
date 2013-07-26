package com.xtihha.study.restlet.db;

import junit.framework.Assert;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;

/**
 * User: zhangxiaohu
 * Date: 13-7-26
 * Time: 下午10:16
 */
public class StudentDaoTest extends DBTestCase {
    private static final Logger logger = LoggerFactory.getLogger(StudentDaoTest.class);

    public StudentDaoTest() {
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://192.168.2.229:3306/test?useUnicode=true&characterEncoding=UTF8&connectTimeout=1000&socketTimeout=3000");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "q3boy");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "123");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        String dbFilePath = this.getClass().getClassLoader().getResource("db/dump.xml").getPath();
        return new FlatXmlDataSet(new FileInputStream(dbFilePath));
    }

    @Test
    public void testGetStudent() throws Exception {
        IDataSet dataset = getDataSet();
        ITable table = getDataSet().getTable("student");
        long id = Long.parseLong((String) table.getValue(0, "id"));
        String name = (String) table.getValue(0, "name");
        Assert.assertTrue(id == 1L);
        Assert.assertEquals(name, "s1");

        table = getDataSet().getTable("department");
        id = Long.parseLong((String) table.getValue(0, "id"));
        name = (String) table.getValue(0, "name");
        String remark = (String) table.getValue(0, "remark");

        Assert.assertTrue(id == 1L);
        Assert.assertEquals(name, "cs1");
        Assert.assertEquals(remark, "remark1");
        Assert.assertFalse(id == 2L);
    }
}
