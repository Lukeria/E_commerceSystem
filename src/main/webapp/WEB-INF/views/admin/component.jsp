<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28-Aug-21
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/component/save/" method="post">
    <label for="componentType">Component type: </label>
    <select name="componentType" id="componentType">
        <option value="glassType">Glass type</option>
        <option value="processing">Processing</option>
        <option value="accessory">Accessory</option>
    </select>
    <label for="name">Name: </label>
    <input type="text" id="name" name="name">
    <label for="symbol">Symbol: </label>
    <input type="text" id="symbol" name="symbol">
    <label for="thickness">Thickness: </label>
    <input type="number" id="thickness" name="thickness">
    <button type="submit">Save</button>
</form>
</body>
</html>
