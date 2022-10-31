package com.mycompany.demopt.dao;

import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class DaoBase {
    private Connection connection;

    public DaoBase() {
        this.connection = Connector.getConnection();
    }
    
    
    
}
