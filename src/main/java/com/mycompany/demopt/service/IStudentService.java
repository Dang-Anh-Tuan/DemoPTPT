/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demopt.service;

import com.mycompany.demopt.model.Student;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IStudentService {
    List<Student> getAll();
    
    Student getById(int id);
    
    void create(String name, int age, int idLocation);
    
    void update(int id, String name, int age, int idLocation);
    
    void delete(int id);
}
