/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.demopt.controller;

import com.mycompany.demopt.service.impl.StudentService;
import com.mycompany.demopt.service.impl.LocationService;
import com.mycompany.demopt.model.Student;
import com.mycompany.demopt.model.Location;
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
@WebServlet(name = "EditStudent", urlPatterns = {"/student/edit"})
public class EditStudent extends HttpServlet {

    private StudentService studentService;
    private LocationService locationService;

    public EditStudent() {
        this.studentService = new StudentService();
        this.locationService = new LocationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Student student = studentService.getById(id);
        List<Location> locations = locationService.getAll();

        req.setAttribute("student", student);
        req.setAttribute("locations", locations);

        String url = "/student/edit_student.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int idLocation = Integer.parseInt(req.getParameter("idLocation"));
        
        studentService.update(id, name, age, idLocation);
        resp.sendRedirect(req.getContextPath() + "/student");
    }
}
