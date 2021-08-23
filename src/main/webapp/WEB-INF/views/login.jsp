<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="<spring:url value='/loginAction'/>">
    <label for="login">Login: </label>
    <input type="text" id="login" name="login">
    <label for="password">Password: </label>
    <input type="password" id="password" name="password">
    <button type="submit">Submit</button>
</form>
</body>
</html>
