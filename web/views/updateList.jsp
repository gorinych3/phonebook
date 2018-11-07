<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 24.10.2018
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ru.egor.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update...</title>
    <link rel="stylesheet" href="../w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>PHONEBOOK</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-orange">
            <h2>Update</h2>
        </div>
    </div>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-orange w3-round-large" onclick="location.href='/updateUser'">Update user</button>
        <button class="w3-btn w3-hover-orange w3-round-large" onclick="location.href='/updatePet'">Update pet</button>

    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/updateList'">Back to update</button>
</div>
</body>
</html>
