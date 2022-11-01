/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.dao.impl;

import com.mycompany.demopt.dao.Connector;
import com.mycompany.demopt.dao.IStatisticDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class StatisticDAO implements IStatisticDAO {

    private Connection connection;

    public StatisticDAO() {
        this.connection = Connector.getConnection();
    }

    @Override
    public Integer statisticCount(String sql) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int result = Integer.parseInt(resultSet.getString(1));
                return result;
            }

            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

}
