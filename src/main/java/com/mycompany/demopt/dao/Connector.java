/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Connector {

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=123456";
        

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url);

            if (connection != null) {
                return connection;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Connect fail");
            System.out.println(e);
        }

        return null;
    }
}
