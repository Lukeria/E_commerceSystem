<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Components</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" \>
</head>
<body>
<table>
    <caption>Glass types</caption>
    <thead>
        <tr>
            <th>Name</th>
            <th>Thickness</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${glassTypeList}">
       <tr>
           <td>${item.name}</td>
           <td>${item.thickness}</td>
       </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <caption>Processing</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Symbol</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${processingList}">
        <tr>
            <td>${item.name}</td>
            <td>${item.symbol}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <caption>Accessory</caption>
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${accessoryList}">
        <tr>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/component/add/">Add</a>
</body>
</html>
