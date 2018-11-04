<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 24.10.2018
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>PHONEBOOK</h1>
</div>

<div class="w3-container w3-padding">
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>User '" + request.getAttribute("userName") + "' updated!</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Update user</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>ID редактируемого пользователя:
                   <input type="text" name="id" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">Поле обязательное для заполнения<br />
               </label>

            <label>Фамилия:
                <input type="text" name="f_name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">Поле обязательное для заполнения<br />
            </label>
            <br>
            <label>Имя:
                <input type="text" name="l_name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">Поле обязательное для заполнения<br />
            </label>
            <br>
            <label>Адрес:
                <input type="text" name="address" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">Поле обязательное для заполнения<br />
            </label>
            <br>
            <label>Домашний телефон:
                <input type="text" name="home_phone" value="unknown" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>

            <label>Мобильный телефон:
                <input type="text" name="m_phone" value="unknown" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>

            <label>Профессия:
                <input type="text" name="profession" value="unknown" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>

            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Принять</button>

        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
