package com.soup.memo.jvm8.classloader.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zhaoyi
 * @date 2019-02-06 23:48
 * @since 1.0
 */
public class ContextTest4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
}
