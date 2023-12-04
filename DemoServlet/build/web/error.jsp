<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // get the error message from request
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
        // print the error message
        out.println("<p style=\"color: red\">" + errorMessage + "</p>");
    }
%>