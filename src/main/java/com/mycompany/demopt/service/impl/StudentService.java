/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.service.impl;

import com.mycompany.demopt.dao.impl.StudentDAO;
import com.mycompany.demopt.model.Student;
import com.mycompany.demopt.service.IStudentService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentService implements IStudentService {

    private StudentDAO dao;

    public StudentService() {
        this.dao = new StudentDAO();
    }

    @Override
    public List<Student> getAll() {
        return this.dao.getAll();
    }

    @Override
    public Student getById(int id) {
        return this.dao.getById(id);
    }

    @Override
    public void create(String name, int age, int idLocation) {
        this.dao.create(name, age, idLocation);
    }

    @Override
    public void delete(int id) {
        this.dao.delete(id);
    }

    @Override
    public void update(int id, String name, int age, int idLocation) {
        this.dao.update(id, name, age, idLocation);
    }

}
