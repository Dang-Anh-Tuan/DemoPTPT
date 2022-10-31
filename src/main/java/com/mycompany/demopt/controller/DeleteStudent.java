package com.mycompany.demopt.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.mycompany.demopt.service.impl.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/student/delete"})
public class DeleteStudent extends HttpServlet {

    private StudentService studentService;

    public DeleteStudent() {
        this.studentService = new StudentService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idDelete = Integer.parseInt(request.getParameter("id"));
        
        this.studentService.delete(idDelete);
        
        response.sendRedirect(request.getContextPath() + "/student");
    }

}
