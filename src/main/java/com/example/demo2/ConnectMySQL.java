package com.example.demo2;

import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectMySQL {
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/testjavaweb";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //Test chương trình. Kích phải chuột chọn run as->java application
    public static void main(String[] args) {
        try {
            new ConnectMySQL();
            System.out.println(ConnectMySQL.getConnection());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
