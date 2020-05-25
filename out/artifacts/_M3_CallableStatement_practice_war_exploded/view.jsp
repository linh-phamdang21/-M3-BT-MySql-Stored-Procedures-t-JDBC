<%--
  Created by IntelliJ IDEA.
  User: phdan
  Date: 23/05/2020
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Test </title>
</head>
<body>
<h1> User List </h1>
<table border="1">
    <tr>
        <td> ID </td>
        <td> Name </td>
        <td> Gender </td>
        <td> Phone </td>
        <td> Address </td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getUserid()}</td>
            <td>${user.getName()}</td>
            <td>${user.isGender()}</td>
            <td>${user.getPhone()}</td>
            <td>${user.getAddress()}</td>
        </tr>
    </c:forEach>
</table>

<table border="1">
    <tr>
        <td> ID </td>
        <td> Name </td>
        <td> Gender </td>
        <td> Phone </td>
        <td> Address </td>
    </tr>
    <c:forEach items="${user_callable}" var="user">
        <tr>
            <td>${user.getUserid()}</td>
            <td>${user.getName()}</td>
            <td>${user.isGender()}</td>
            <td>${user.getPhone()}</td>
            <td>${user.getAddress()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
