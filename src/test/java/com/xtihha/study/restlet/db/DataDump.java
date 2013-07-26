package com.xtihha.study.restlet.db;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * User: zhangxiaohu
 * Date: 13-7-26
 * Time: 下午9:54
 */
public class DataDump {
    public static void main(String... args) throws ClassNotFoundException, SQLException, DatabaseUnitException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.229:3306/test?useUnicode=true&characterEncoding=UTF8&connectTimeout=1000&socketTimeout=3000", "q3boy", "123");
        IDatabaseConnection connection = new DatabaseConnection(conn);
        QueryDataSet dataset = new QueryDataSet(connection);

        dataset.addTable("student");
        dataset.addTable("department");
        FlatXmlDataSet.write(dataset, new FileOutputStream("dump.xml"));

        System.out.println("dump done");
    }
}
