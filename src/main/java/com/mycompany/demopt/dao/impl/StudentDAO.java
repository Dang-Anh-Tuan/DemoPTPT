/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demopt.dao.impl;

import com.mycompany.demopt.dao.Connector;
import com.mycompany.demopt.dao.IStudentDAO;
import com.mycompany.demopt.model.Location;
import com.mycompany.demopt.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentDAO implements IStudentDAO {

    private Connection connection;

    public StudentDAO() {
        this.connection = Connector.getConnection();
    }

    @Override
    public List<Student> getAll() {
        try {
            String sql = "SELECT * FROM \n"
                    + "   tbl_student, tbl_location \n"
                    + "   WHERE tbl_student.idLocation = tbl_location.id;";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (result.next()) {
                int id = Integer.parseInt(result.getString(1));
                String name = result.getString(2);
                int age = Integer.parseInt(result.getString(3));
                int idLocation = Integer.parseInt(result.getString(4));
                String nameLocation = result.getString(6);

                Student student = new Student(id, name, age, new Location(idLocation, nameLocation));
                students.add(student);
            }

            return students;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public Student getById(int id) {
        try {
            System.out.println(id);
            String sql = "SELECT * FROM \n"
                    + "   tbl_student, tbl_location \n"
                    + "   WHERE tbl_student.id = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Student student = new Student();

            while (result.next()) {
                int idStudent = Integer.parseInt(result.getString(1));
                String name = result.getString(2);
                int age = Integer.parseInt(result.getString(3));
                int idLocation = Integer.parseInt(result.getString(4));
                String nameLocation = result.getString(6);

                student.setId(idStudent);
                student.setName(name);
                student.setAge(age);
                Location location = new Location(idLocation, nameLocation);
                student.setLocation(location);
            }

            return student;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public void create(String name, int age, int idLocation) {
        try {
            String sql = "INSERT INTO tbl_student (name, age, idLocation)\n"
                    + "VALUES (?, ?, ?);";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, idLocation);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Insert sucssess");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(int id, String name, int age, int idLocation) {
        try {
            String sql = "UPDATE tbl_student SET name = ? , age = ?, idLocation = ? WHERE id = ?";

            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, idLocation);
            statement.setInt(4, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Delete success");
            }

        } catch (Exception e) {
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM tbl_student WHERE id = ?";

            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Delete success");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
