<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" \>
</head>
<body>
    <input type="hidden" id="glassTypeList" value='${glassTypeList}'>
    <input type="hidden" id="processingList" value='${processingList}'>
<form id="calculatorForm" action="/order/create" method="post">
    <label for="productType">Product type: </label>
    <input type="text" id="productType" name="productType">
    <p>Glass</p>
    <table>
        <tbody id="glass">
        </tbody>
    </table>
    <table>
        <tbody id="accessory">
        </tbody>
    </table>
    <table>
        <tbody id="extraService">
        </tbody>
    </table>
    <a href="javascript:void(0);" id="addRaw">Add raw</a>
    <input id="tableJSON" type="hidden" name="tableJson">
    <label>Result: </label>
    <%--    <input type="text" id="result" name="result" value="${result}">--%>
    <security:authorize access="hasRole('ADMIN')">
        <input type="text" id="result" name="result">
    </security:authorize>
    <security:authorize access="!hasRole('ADMIN')">
        <p id="resultText"></p>
    </security:authorize>
    <button type="button" id="calculate">Calculate</button>
    <security:authorize access="!hasRole('ADMIN')">
        <button type="button" id="addToCart">Add to cart</button>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
    <button type="submit" id="addOrder">Next</button>
    </security:authorize>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom/calculator.js"></script>
</body>
</html>
