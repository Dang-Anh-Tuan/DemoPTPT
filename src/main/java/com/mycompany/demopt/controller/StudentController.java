/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demopt.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.demopt.model.Student;
import com.mycompany.demopt.service.impl.StudentService;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "student", urlPatterns = {"/student"})
public class StudentController extends HttpServlet {

    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = this.studentService.getAll();

        req.setAttribute("students", students);
        String url = "student/list_student.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
