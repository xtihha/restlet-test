package com.xtihha.study.restlet.manager;

import com.xtihha.study.restlet.domain.Student;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mockit;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * User: zhangxiaohu
 * Date: 13-7-21
 * Time: 下午6:40
 */
public class ServiceManagerTest {
    private static final Logger logger = LoggerFactory.getLogger(ServiceManagerTest.class);
    private Student student;
    private ServiceManager serviceManager;

    @BeforeClass
    public static void onInitialize() {
        logger.info("on initialized...");
    }

    @AfterClass
    public static void onDestryoed() {
        logger.info("on destryoed...");
        Mockit.tearDownMocks();
    }

    @Before
    public void before() {
        logger.info("before...");
        serviceManager = new ServiceManager();
        student = new Student();

        student.setId(1);
        student.setName("z1");
        student.setDepartment("cs");
    }

    @After
    public void after() {
        logger.info("after...");
    }

    @Test
    public void testGetStudent() {
        new MockUp<ServiceManager>() {
            @Mock
            public Student getStudent(long id) {
                return student;
            }
        };

        Student tmp = serviceManager.getStudent(2L);
        assertNotNull(tmp);
        logger.info("Mock Student[{}]", tmp);

        assertTrue(tmp.getId() == student.getId());
        assertTrue(tmp.getName().equals(student.getName()));
        assertTrue(tmp.getDepartment().equals(student.getDepartment()));


        new MockUp<ServiceManager>() {
            @Mock
            public Student getStudent(long id) {
                return null;
            }
        };

        Student tmp2 = serviceManager.getStudent(123L);
        logger.info("Mock Null Student[{}]", tmp2);
        assertNull(tmp2);
    }

}
