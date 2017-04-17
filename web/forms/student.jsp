
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: none;">
    <label>entity type</label>
    <input type="text" name="type" value="student">

</div>

    <c:choose>
        <c:when test="${param.create != null}">
            <form action="/list?type=student" method="post">
    <label>first name</label>
    <input type="text" placeholder="first name" name="first_name">
    <br>
    <label>last name</label>
    <input type="text" placeholder="last name" name="last_name">
    <br>
    <label>group number</label>
    <input type="number" placeholder="group number" name="group_number">
    <br>
    <label>avg_mark</label>
    <input type="text" placeholder="mark" name="avg_mark">
    <br>
    <label>avg_mark</label>
    <input type="text" placeholder="id" name="id">
    <br>

    <input type="submit" name="create" value="CREATE">
</form>
        </c:when>
        <c:when test="${param.update != null}">
<form action="/list" method="post">
            <label>first name</label>

            <input type="text" placeholder="${requestScope["currentStudent"].firstName}" name="first_name" value="${requestScope["currentStudent"].firstName}">
            <br>
            <label>last name</label>
            <input type="text" placeholder="${state.lastName}" name="last_name" value="${stat.lastName}">
            <br>
            <label>group number</label>
            <input type="number" placeholder="${sessionScope.state.groupNumber}" name="group_number" value="${sessionScope.state.groupNumber}">
            <br>
            <label>avg_mark</label>
            <input type="text" placeholder="${sessionScope.state.avg_mark}" name="avg_mark" value="${sessionScope.state.avg_mark}">
            <input type="submit" name="update" value="UPDATE">
</form>
        </c:when>
        <c:when test="${param.delete != null}">
            <input type="submit" name="delete" value="DELETE">
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>
    <%--<c:if test="${requestScope['create']==null}">--%>

    <%--</c:if>--%>
<%--</c:if>--%>

<a href="/list?choice=student">BACK</a>
<a href="/list&type=student&create=true">ADD</a>
<c:out value="${requestScope['state']}" />
</body>
</html>
