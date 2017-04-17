<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 15.04.2017
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="tablepages.css">
    <link rel="stylesheet" href="sectionStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="table-title">
    <h3>Student List</h3>
</div>
<div align="center">
    <table class="table-fill">
        <thead>
        <tr>
            <th class="text-left">ID</th>
            <th class="text-left">First name</th>
            <th class="text-left">Last name</th>
            <th class="text-left">Mark</th>
            <th class="text-left">Group number</th>
            <th class="text-left"></th>
            <th class="text-left"></th>
        </tr>
        </thead>


<tbody>
<c:forEach var="student" items="${studentList}" >
<tr>

    <td class="text-left">${student.id}</td>
    <td class="text-left">${student.firstName}</td>
    <td class="text-left">${student.lastName}</td>
    <td class="text-left">${student.avg_mark}</td>
    <td class="text-left">${student.groupNumber}</td>
    <td class="edit-style"><a href="/forms/student.jsp?type=student"><i class="fa fa-edit"></i></a></td>
    <td class="remove-style"><i class="fa fa-remove"></i></td>
</tr>
</c:forEach>
</tbody>


    </table>
    <a href="/sectionpage.jsp"><i class="fa fa-undo"></i></a>
    <a href="/forms/student.jsp?type=student&create=true"><i class="fa fa-plus-circle"></i></a>
</div>
</body>
</html>
