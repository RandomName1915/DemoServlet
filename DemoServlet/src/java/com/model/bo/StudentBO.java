package com.model.bo;

import java.util.List;

import com.model.bean.StudentBEAN;
import com.model.dao.StudentDAO;

public class StudentBO {
    private StudentDAO studentDAO;
    
    public StudentBO() throws ClassNotFoundException {
        this.studentDAO = new StudentDAO();
    }

    public List<StudentBEAN> getAll() {
        return this.studentDAO.getAll();
    }

    public StudentBEAN getById(String id) {
        return this.studentDAO.getById(id);
    }

    public void store(StudentBEAN student) throws Exception {
        try {
            this.studentDAO.store(student);
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(StudentBEAN student) throws Exception {
        try {
            this.studentDAO.update(student);
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(String[] ids) throws Exception {
        try {
            this.studentDAO.delete(ids);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<StudentBEAN> find(String q, String university) {
        return this.studentDAO.find(q, university);
    }
}
