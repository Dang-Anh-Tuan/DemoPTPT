/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demopt.controller;

import com.mycompany.demopt.model.Location;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.demopt.model.Student;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "student", urlPatterns = {"/student"})
public class StudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();

        Location location1 = new Location(1, "Ha noi");
        Location location2 = new Location(1, "HCM");

        Student student1 = new Student(1, "Tuan", 18, location1);
        Student student2 = new Student(2, "Duc", 10, location1);
        Student student3 = new Student(3, "Dat", 5, location2);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        req.setAttribute("students", students);
        String url = "list_student.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }

}
