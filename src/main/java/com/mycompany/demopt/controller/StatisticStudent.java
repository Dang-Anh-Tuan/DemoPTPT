/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.demopt.controller;

import com.mycompany.demopt.service.impl.LocationService;
import com.mycompany.demopt.model.Location;
import com.mycompany.demopt.service.impl.StatisticService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "StatisticStudent", urlPatterns = {"/student/statistic"})
public class StatisticStudent extends HttpServlet {

    private final LocationService locationService;
    private StatisticService statisticService;

    public StatisticStudent() {
        this.locationService = new LocationService();
        this.statisticService = new StatisticService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Location> locations = this.locationService.getAll();

        req.setAttribute("locations", locations);

        String url = "/student/statistic.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idLocation = Integer.parseInt(req.getParameter("idLocation"));
        
        String sql = "EXEC CountSVByLocation @idLocation = " + idLocation + ";";
        Integer result = this.statisticService.statisticCount(sql);
        
        req.setAttribute("result", result);
        String url = "/student/result_statistic.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

}
