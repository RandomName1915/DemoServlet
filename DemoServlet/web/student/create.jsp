<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../error.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm sinh viên</title>
</head>

<body>
    <h2>Thêm sinh viên</h2>
    <form action="studentController?action=store" method="post">
        Mã
        <input type="text" name="id" id="id-input">
        <span id="id-error" class="display-error"></span>
        <br>
        Tên
        <input type="text" name="name">
        <br>
        Tuổi
        <input type="text" name="age">
        <br>
        Trường
        <input type="text" name="university">
        <br>
        <button>Thêm</button>
        <button type="reset">Reset</button>
    </form>

    <p>
        <a href="/DemoServlet">
            Trang chủ
        </a>
    </p>
</body>
</html>