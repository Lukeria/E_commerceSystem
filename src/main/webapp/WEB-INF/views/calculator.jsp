<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" \>
</head>
<body>
<input type="hidden" id="glassTypeList" value='${glassTypeList}'>
<input type="hidden" id="processingList" value='${processingList}'>
<form id="calculatorForm">
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
    <input id="tableJSON" type="hidden">
    <label for="result">Result: </label>
    <%--    <input type="text" id="result" name="result" value="${result}">--%>
    <input type="text" id="result" name="result">
    <button type="submit">Calculate</button>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom/calculator.js"></script>
</body>
</html>
