package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.model.bean.StudentBEAN;
import com.model.bo.StudentBO;

@WebServlet("/studentController")
public class StudentController extends HttpServlet {
    private StudentBO studentBO;

    public StudentController() throws ClassNotFoundException {
        this.studentBO = new StudentBO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "index";
        }

        switch (action) {
            case "index":
                this.index(request, response);
                break;
            case "getOne":
                this.getOne(request, response);
                break;
            case "create":
                this.create(request, response);
                break;
            case "store":
                this.store(request, response);
                break;
            case "edit_list":
                this.edit_list(request, response);
                break;
            case "edit":
                this.edit(request, response);
                break;
            case "update":
                this.update(request, response);
                break;
            case "delete_list":
                this.delete_list(request, response);
                break;
            case "delete":
                this.delete(request, response);
            case "search":
                this.search(request, response);
                break;
            case "find":
                this.find(request, response);
                break;
            default:
                response.getWriter().println("Đã có lỗi xảy ra");
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<StudentBEAN> students = this.studentBO.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("student/index.jsp").forward(request, response);
    }

    public void getOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        StudentBEAN student = this.studentBO.getById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("student/detail.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("student/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String university = request.getParameter("university");

            StudentBEAN student = new StudentBEAN(id, name, age, university);
            this.studentBO.store(student);

            response.sendRedirect("studentController");
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("student/create.jsp").forward(request, response);
        }
    }

    public void edit_list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<StudentBEAN> students = this.studentBO.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("student/edit_list.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        StudentBEAN student = this.studentBO.getById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("student/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String university = request.getParameter("university");

            System.out.println("id " + id);
            System.out.println(name);
            System.out.println(age);
            System.out.println(university);

            StudentBEAN student = new StudentBEAN(id, name, age, university);
            this.studentBO.update(student);

            List<StudentBEAN> students = this.studentBO.getAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("student/edit_list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("student/edit.jsp").forward(request, response);
        }
    }

    public void delete_list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<StudentBEAN> students = this.studentBO.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("student/delete_list.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String[] ids = request.getParameterValues("studentIds[]");
            this.studentBO.delete(ids);

            List<StudentBEAN> students = this.studentBO.getAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("student/delete_list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("student/delete_list.jsp").forward(request, response);
        }
    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("student/search.jsp").forward(request, response);
    }

    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String q = request.getParameter("q");
        String university = request.getParameter("university");

        List<StudentBEAN> students = this.studentBO.find(q, university);

        if (students.size() == 0) {
            request.setAttribute("errorMessage", "Không tìm thấy kết quả nào.");
            request.getRequestDispatcher("student/search.jsp").forward(request, response);
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("student/search.jsp").forward(request, response);
    }
}

