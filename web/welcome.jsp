<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 04.04.2017
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome page</title>

  <meta name="IE" content="your name" />
  <meta name="description" content="" />

  <!-- you should always add your stylesheet (css) in the head tag so that it starts loading before the page html is being displayed -->
  <link rel="stylesheet" href="styleWelcome.css" type="text/css" />
</head>
<body>


<!-- webpage content goes here in the body -->

<div id="page">
  <div id="logo">
    <h1><a href="/" id="logoLink">Students RB</a></h1>
  </div>
  <div id="nav">
    <ul>
      <li><a href="/welcome.jsp">Home</a></li>
      <li><a href="/loginpage.jsp">Login</a></li>
    </ul>
  </div>
  <div id="content">

    <p>
     This is welcome page.For login, click on Login.
    </p>

  </div>
  <div id="footer">
    <p>
      Webpage made by <a href="/" target="_blank">Igor Yermachonak</a>
    </p>
  </div>
</div>

</body>
</html>
