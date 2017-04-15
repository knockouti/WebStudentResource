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
        <c:when test="${(message.stringRole eq 'STUDENT') ||(message.stringRole eq 'PROFESSOR')}">
            <form action="studentlist.jsp">
                <input type="submit" class="selection-type button button1" value="Students List">
            </form>
            <form action="groups.jsp">
                <input type="submit" class="selection-type button button1" value="Groups">
            </form>
            <form action="professors.jsp">
                <input type="submit" class="selection-type button button1" value="Professors">
            </form>
            <form action="mark.jsp">
                <input type="submit" class="selection-type button button1" value="Mark">
            </form>
            <form action="stydies.jsp">
                <input type="submit" class="selection-type button button1" value="Studies">
            </form>
            <form action="welcome.jsp">
                <input type="submit" class="selection-type1 button button2" value="Send Message">

            </form>
            <form action="welcome.jsp">
                <input type="submit" class="selection-type1 button button2" value="Read Message">
            </form>
        </c:when>
        <c:when test="${message.stringRole eq 'ADMIN'}">
            <form action="studentlist.jsp">
                <input type="submit" class="selection-type button button1" value="Students List">
            </form>
            <form action="groups.jsp">
                <input type="submit" class="selection-type button button1" value="Groups">
            </form>
            <form action="professors.jsp">
                <input type="submit" class="selection-type button button1" value="Professors">
            </form>
            <form action="mark.jsp">
                <input type="submit" class="selection-type button button1" value="Mark">
            </form>
            <form action="stydies.jsp">
                <input type="submit" class="selection-type button button1" value="Studies">
            </form>
            <form action="users.jsp">
                <input type="submit" class="selection-type button button1" value="Users">
            </form>
            <form action="welcome.jsp">
                <input type="submit" class="selection-type1 button button2" value="Read Message" >
            </form>
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

