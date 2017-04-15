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



    <link rel="stylesheet" href="loginstyle.css">
    <link rel="stylesheet" href="sectionStyle.css">


</head>

<body>
<div class="login">
    <div class="login-triangle"></div>

    <h2 class="login-header">Log in</h2>

    <form class="login-container" action="/ServletLogin" method="POST">
        <p><input type="text" name="Login"></p>
        <p><input type="text" name="Password"></p>
        <p class= "message-error">${errorMessage}</p>
        <p><input type="submit" value="Login"></p>
    </form>

</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>

