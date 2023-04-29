package com.xiaohe.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C3P0Test {
    public static ComboPooledDataSource cpds;
    public static Connection connection;

    public static void getConnection() {
        cpds = new ComboPooledDataSource();
    }

    public static void queryData() {
        try {
            connection = cpds.getConnection();
            String sql = "select * from sys_config";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // ComboPooledDataSource cpds = new ComboPooledDataSource();
        // try {
        //     cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        //     cpds.setJdbcUrl("jdbc:mysql://localhost:3307/sys");
        //     cpds.setUser("root");
        //     cpds.setPassword("123456");
        //     Connection connection = cpds.getConnection();
        //     System.out.println(connection);
        //     connection.close();
        // } catch (Exception e) {
        //     throw new RuntimeException(e);
        // }

        getConnection();
        queryData();
    }
}
