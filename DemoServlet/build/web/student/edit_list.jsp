<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.bean.StudentBEAN" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập nhật sinh viên</title>
</head>

<body>
    <h2>Cập nhật sinh viên</h2>
    <table border="1" width="100%">
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Trường</th>
            <th>Cập nhật</th>
        </tr>
        <%
             List<StudentBEAN> students = (List<StudentBEAN>) request.getAttribute("students");
        %>
        
        <% for (StudentBEAN student : students) { %>
            <tr>
                <td><%= student.showId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getAge() %></td>
                <td><%= student.getUniversity() %></td>
                <td><a href="/DemoServlet/studentController?action=edit&id=<%= student.getId() %>">Cập nhật</a></td>
            </tr>
        <% } %>
        
    </table>

    <p>
        <a href="/DemoServlet">
            Trang chủ
        </a>
    </p>
</body>

</html>