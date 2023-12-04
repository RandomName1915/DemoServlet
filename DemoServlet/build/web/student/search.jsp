<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.bean.StudentBEAN" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tìm kiếm sinh viên</title>
</head>

<body>
    <h2>Tìm kiếm sinh viên</h2>
    <form method="post" action="/DemoServlet/studentController?action=find">
        <select name="university">
            <option value="DUT">DUT</option>
            <option value="DUE">DUE</option>
            <option value="UED">UED</option>
            <option value="VKU">VKU</option>
        </select>
        <br>
        <input type="text" name="q" placeholder="Nhập thông tin cần tìm kiếm">
        <input type="submit" value="Tìm kiếm">
    </form>

    <%
        if (request.getAttribute("students") != null) {
            List<StudentBEAN> students = (List<StudentBEAN>) request.getAttribute("students");
            if (students.size() > 0) {
    %>
    <table border="1">
        <tr>
            <th>Mã sinh viên</th>
            <th>Họ tên</th>
            <th>Tuổi</th>
            <th>Trường</th>
        </tr>
        <%
                for (StudentBEAN student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getUniversity() %></td>
        </tr>
        <%
                }
        %>
    </table>
    <%
            } else {
    %>
        <p>Không tìm thấy sinh viên nào</p>
    <%
            }
        }
    %>

    <p>
        <a href="/DemoServlet">
            Trang chủ
        </a>
    </p>
</body>

</html>