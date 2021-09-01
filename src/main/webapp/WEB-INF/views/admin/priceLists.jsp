<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Price list</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" \>
</head>
<body>
<p><label for="currency">1 USD = </label><input id="currency" type="number" name="currency"> BYN </p>
<p><label for="currency">Increase per cent: </label><input id="increasePercent" type="number" name="increasePercent"> %</p>
<form id="priceListForm">
    <button type="button" id="updatePrices">Update prices</button>
    <button type="submit">Save</button>
</form>
<table>
    <caption>Glass types</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Thickness</th>
        <th>Price (USD)</th>
        <th>Price (BYN)</th>
        <th><a href="javascript:void(0);" id="glass_selectAll">Select all</a></th>
    </tr>
    </thead>
    <tbody id="glass">
    <c:forEach var="item" items="${glassTypeList}" varStatus="counter">
        <tr>
            <td style="display:none;" id="id_${counter.count}">${item.id}</td>
            <td id="name_${counter.count}">${item.name}</td>
            <td id="thickness_${counter.count}">${item.thickness}</td>
            <td><input type="number" value="${item.priceUSD}" id="priceUSD_${counter.count}"></td>
            <td><input type="number" value="${item.price}" id="price_${counter.count}"></td>
            <td><input type="checkbox" id="selected_${counter.count}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <caption>Processing</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Price (USD)</th>
        <th>Price (BYN)</th>
        <th><a href="javascript:void(0);" id="processing_selectAll">Select all</a></th>
    </tr>
    </thead>
    <tbody id="processing">
    <c:forEach var="item" items="${processingList}" varStatus="counter">
        <tr>
            <td style="display:none;" id="id_${counter.count}">${item.id}</td>
            <td id="name_${counter.count}">${item.name}</td>
            <td><input type="number" value="${item.priceUSD}" id="priceUSD_${counter.count}"></td>
            <td><input type="number" value="${item.price}" id="price_${counter.count}"></td>
            <td><input type="checkbox" id="selected_${counter.count}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <caption>Accessory</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Price (USD)</th>
        <th>Price (BYN)</th>
        <th><a href="javascript:void(0);" id="accessory_selectAll">Select all</a></th>
    </tr>
    </thead>
    <tbody id="accessory">
    <c:forEach var="item" items="${accessoryList}" varStatus="counter">
        <tr>
            <td style="display:none;" id="id_${counter.count}">${item.id}</td>
            <td id="name_${counter.count}">${item.name}</td>
            <td><input type="number" value="${item.priceUSD}" id="priceUSD_${counter.count}"></td>
            <td><input type="number" value="${item.price}" id="price_${counter.count}"></td>
            <td><input type="checkbox" id="selected_${counter.count}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div><p id="successMessage"></p></div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom/priceLists.js"></script>
</body>
</html>
