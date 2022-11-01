/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.service.impl;

import com.mycompany.demopt.dao.impl.StatisticDAO;
import com.mycompany.demopt.service.IStatisticService;

/**
 *
 * @author Admin
 */
public class StatisticService implements IStatisticService {

    private StatisticDAO statisticDAO;

    public StatisticService() {
        this.statisticDAO = new StatisticDAO();
    }

    @Override
    public Integer statisticCount(String sql) {
        return this.statisticDAO.statisticCount(sql);
    }

}
