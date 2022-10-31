/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.dao.impl;

import com.mycompany.demopt.dao.Connector;
import com.mycompany.demopt.dao.ILocation;
import com.mycompany.demopt.model.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LocationDAO implements ILocation{

    private Connection connection;

    public LocationDAO() {
        this.connection = Connector.getConnection();
    }

    @Override
    public List<Location> getAll() {
        try {
            String sql = "SELECT * FROM \n"
                    + "   tbl_location;";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            List<Location> locations = new ArrayList<>();

            while (result.next()) {
                int id = Integer.parseInt(result.getString(1));
                String name = result.getString(2);
                
                locations.add(new Location(id, name));
            }

            return locations;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    
}
