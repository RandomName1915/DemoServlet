<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản lý sinh viên</title>
</head>

<body>
  <h2>Quản lý sinh viên</h2>
  <ul>
    <li>
      <a href="/DemoServlet/studentController">
        1. Xem sinh viên
      </a>
    </li>
    <li>
      <a href="/DemoServlet/studentController?action=create">
        2. Thêm sinh viên
      </a>
    </li>
    <li>
      <a href="/DemoServlet/studentController?action=edit_list">
        3. Cập nhật sinh viên
      </a>
    </li>
    <li>
      <a href="/DemoServlet/studentController?action=delete_list">
        4. Xoá sinh viên
      </a>
    </li>
    <li>
      <a href="/DemoServlet/studentController?action=search">
        5. Tìm kiếm sinh viên
      </a>
    </li>
  </ul>
</body>

</html>
