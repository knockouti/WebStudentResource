<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 11.04.2017
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Table Style</title>
    <meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
    <link rel="stylesheet" href="tablepages.css">
    <link rel="stylesheet" href="sectionStyle.css">
</head>

<body>
<div class="table-title">
    <h3>Student List</h3>
</div>
<table class="table-fill" >
    <thead>
    <tr>
        <th class="text-left">ID</th>
        <th class="text-left">First name</th>
        <th class="text-left">Last name</th>
        <th class="text-left">Mark</th>
        <th class="text-left">Group number</th>
    </tr>
    </thead>
    <tbody class="table-hover">
    <tr>
        <th class="text-left">${first_name}</th>
        <th class="text-left">${last_name}</th>
        <th class="text-left">${avg_mark}</th>
        <th class="text-left">${group_number}</th>
    </tr>
    <tr>
        <td class="text-left">February</td>
        <td class="text-left">$ 10,000.00</td>
        <td class="text-left">$ 50,000.00</td>
        <td class="text-left">$ 50,000.00</td>
    </tr>
    <tr>
        <td class="text-left">March</td>
        <td class="text-left">$ 85,000.00</td>
        <td class="text-left">$ 50,000.00</td>
        <td class="text-left">$ 50,000.00</td>
    </tr>
    <tr>
        <td class="text-left">April</td>
        <td class="text-left">$ 56,000.00</td>
        <td class="text-left">$ 50,000.00</td>
        <td class="text-left">$ 50,000.00</td>
    </tr>
    <tr>
        <td class="text-left">May</td>
        <td class="text-left">$ 98,000.00</td>
        <td class="text-left">$ 50,000.00</td>
        <td class="text-left">$ 50,000.00</td>
    </tr>
    </tbody>
</table>
<div style="display: none;">
    <label>entity type</label>
    <input type="text" name="type" value="student">
    <input type="text" placeholder="id" name="id" value="${id}">
</div>
<form action="/section" method = "post">
    <input class="selection-type1 button button2" type="submit" value="Add" align="left">
    <p>${first_name}</p>
    <p>${last_name}</p>
    <input class="selection-type1 button button2" type="submit" value="Delete" align="right">
</form>
</body>