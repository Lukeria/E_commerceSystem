<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/login">
    <label for="login">Login: </label>
    <input type="text" id="login" name="login">
    <label for="password">Password: </label>
    <input type="password" id="password" name="password">
    <button type="submit">Submit</button>
</form>
</body>
</html>
