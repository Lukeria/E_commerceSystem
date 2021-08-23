<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/login">
    <label for="username">Login: </label>
    <input type="text" id="username" name="username">
    <label for="password">Password: </label>
    <input type="password" id="password" name="password">
    <button type="submit">Submit</button>
</form>
</body>
</html>
