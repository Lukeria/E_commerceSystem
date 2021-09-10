<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
</head>
<body>
<security:authorize access="!isAuthenticated()">
    <a href="/registrationPage">Registration</a>
    <a href="/login">Login</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <a href="/profile/">Profile</a>
    <a href="/logout">Logout</a>
</security:authorize>
<div>
    <a href="/main">About</a>
    <a href="/calculator/">Calculate order</a>
    <a href="/catalog/">Catalog</a>
<security:authorize access="hasRole('USER')">
    <a href="/cart/">Cart</a>
</security:authorize>
</div>
</body>
</html>
