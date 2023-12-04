<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.bean.StudentBEAN" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xem sinh viên</title>
</head>

<body>
    <h2>Danh sách sinh viên</h2>
    <table border="1" width="100%">
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Xem chi tiết</th>
        </tr>
        <%
             List<StudentBEAN> students = (List<StudentBEAN>) request.getAttribute("students");
        %>
        
        <% for (StudentBEAN student : students) { %>
            <tr>
                <td><%= student.showId() %></td>
                <td><%= student.getName() %></td>
                <td><a href="/DemoServlet/studentController?action=getOne&id=<%= student.getId() %>">Xem chi tiết</a></td>
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