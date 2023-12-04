<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.model.bean.StudentBEAN" %>
<%@ include file="../error.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập nhật sinh viên</title>
</head>

<body>
    <h2>Cập nhật sinh viên</h2>
    <%
        StudentBEAN student = (StudentBEAN) request.getAttribute("student");
    %>
    <form action="studentController?action=update" method="post">
        Mã
        <input type="text" name="id" id="id-input" value="<%= student.getId() %>" readonly>
        <span id="id-error" class="display-error"></span>
        <br>
        Tên
        <input type="text" name="name" value="<%= student.getName() %>">
        <br>
        Tuổi
        <input type="text" name="age" value="<%= student.getAge() %>">
        <br>
        Trường
        <input type="text" name="university" value="<%= student.getUniversity() %>">
        <br>
        <button>Cập nhật</button>
    </form>

    <p>
        <a href="/DemoServlet/studentController?action=edit_list">
            Quay lại
        </a>
    </p>
</body>
</html>