/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.service.impl;

import com.mycompany.demopt.dao.ILocation;
import com.mycompany.demopt.dao.impl.LocationDAO;
import com.mycompany.demopt.model.Location;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LocationService implements ILocation {

    private LocationDAO locationDAO;

    public LocationService() {
        this.locationDAO = new LocationDAO();
    }

    @Override
    public List<Location> getAll() {
        return locationDAO.getAll();
    }

}
