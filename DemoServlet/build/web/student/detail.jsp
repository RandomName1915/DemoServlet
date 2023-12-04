<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <th>Tuổi</th>
            <th>Trường</th>
        </tr>
        <%
            StudentBEAN student = (StudentBEAN) request.getAttribute("student");
        %>
        <tr>
            <td><%= student.showId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getUniversity() %></td>
        </tr>
    </table>

    <p>
        <a href="javascript:history.back()">
            Back
        </a>
    </p>
</body>

</html>