<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form method="post" action="/register">
        <label for="login">Login: </label>
        <input type="text" id="login" name="login">
        <label for="password">Password: </label>
        <input type="password" id="password" name="password">
        <label for="passwordRepeat">Password repeat: </label>
        <input type="password" id="passwordRepeat" name="passwordRepeat">
        <label for="email">Email: </label>
        <input type="email" id="email" name="email">
        <button type="submit">Submit</button>
    </form>
</body>
</html>
