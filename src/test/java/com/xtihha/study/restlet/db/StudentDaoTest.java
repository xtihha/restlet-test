package com.xtihha.study.restlet.db;

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
    private IDataSet dataset;

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

    /**
     * 需要override TestCase里面的方法，测试无法使用@Before @BeforeClass
     *
     * @throws Exception
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        dataset = getDataSet();
        logger.info("consturct dataset successfully");
    }

    @Test
    public void testGet() throws Exception {
        ITable table = dataset.getTable("student");
        long id = Long.parseLong((String) table.getValue(0, "id"));
        String name = (String) table.getValue(0, "name");
        assertTrue(id == 1L);
        assertEquals(name, "s1");

        table = dataset.getTable("department");
        id = Long.parseLong((String) table.getValue(0, "id"));
        name = (String) table.getValue(0, "name");
        String remark = (String) table.getValue(0, "remark");

        assertTrue(id == 1L);
        assertEquals(name, "cs1");
        assertEquals(remark, "remark1");
        assertFalse(id == 2L);
    }

    @Override
    public void tearDown() {
        logger.info("tear down...");
    }
}
