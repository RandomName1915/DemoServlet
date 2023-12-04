package com.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.ConnectDB;
import com.model.bean.StudentBEAN;

public class StudentDAO {
    private final String tableName = "sinhvien";
    private Connection connection;

    public StudentDAO() throws ClassNotFoundException {
        this.connection = ConnectDB.getInstance().getConnection();
    }

    public List<StudentBEAN> getAll() {
        List<StudentBEAN> students = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                StudentBEAN student = new StudentBEAN(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("university")
                );
                
                students.add(student);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return students;
    }

    public StudentBEAN getById(String id) {
        StudentBEAN student = null;
        String sql = "SELECT * FROM " + tableName + " WHERE id = '" + id + "'";

        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                student = new StudentBEAN(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("university")
                );
            } 

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public void store(StudentBEAN student) throws Exception {
        StudentBEAN studentBEAN = this.getById(student.getId());
        if (studentBEAN != null) {
            throw new Exception("Mã sinh viên đã tồn tại.");
        }

        String sql = "INSERT INTO " + tableName + " VALUES ('" + student.getId() + "', '" + student.getName() + "', " + student.getAge() + ", '" + student.getUniversity() + "')";

        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(StudentBEAN student) throws Exception {
        StudentBEAN studentBEAN = this.getById(student.getId());
        if (studentBEAN == null) {
            throw new Exception("Mã sinh viên không tồn tại.");
        }

        String sql = "UPDATE " + tableName + " SET name = '" + student.getName() + "', age = " + student.getAge() + ", university = '" + student.getUniversity() + "' WHERE id = '" + student.getId() + "'";

        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(String[] ids) throws Exception {
        String sql = "DELETE FROM " + tableName + " WHERE id IN (";

        for (int i = 0; i < ids.length; i++) {
            sql += "'" + ids[i] + "'";
            if (i < ids.length - 1) {
                sql += ", ";
            }
        }

        sql += ")";

        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<StudentBEAN> find(String q, String university) {
        List<StudentBEAN> students = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " WHERE id LIKE '%" + q + "%' OR name LIKE '%" + q + "%' OR age LIKE '%" + q + "%' OR university LIKE '%" + q + "%' and university = '" + university + "'";
        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                StudentBEAN student = new StudentBEAN(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("university")
                );
                
                students.add(student);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return students;
    }
}
