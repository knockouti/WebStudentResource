<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 04.04.2017
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>

    <meta charset="UTF-8">
    <title>Login Form</title>



    <link rel="stylesheet" href="sectionStyle.css">


</head>

<body>
<div class="login">
    <div class="login-triangle"></div>

    <h2 class="login-header">Section Page</h2>
<div class="login-container">

    <c:set var="message" value='${requestScope["role"]}' />
    <c:choose>
        <c:when test="${(message.stringRole eq 'ADMIN') ||(message.stringRole eq 'PROFESSOR')}">
            <ul>
                <h3> Choose option</h3>
                <li>
                    <a href="/section?choice=group">group list</a>
                </li>
                <li>
                    <a href="/section?choice=student">students list</a>
                </li>
                <li>
                    <a href="/section?choice=professor">professors list</a>
                </li>
                <li>
                    <a href="/section?choice=mark">marks list</a>
                </li>
                <li>
                    <a href="/section?choice=study">studies list</a>
                </li>
                <li>
                    <a href="/section?choice=user">users list</a>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <c:redirect url="/loginpage.jsp"/>
        </c:otherwise>
    </c:choose>


       
          
    
</div>


</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>

