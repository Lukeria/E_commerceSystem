<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:url value="/order/update" var="orderAdd"/>
<form:form method="post" action="${orderAdd}" modelAttribute="order">
<%--        <input path="glassList" value="${tableJson}" type="hidden"/>--%>
    <spring:bind path="customer.name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <form:input path="customer.name" type="text" class="form-control"
                            id="name" placeholder="Name"/>
                <form:errors path="customer.name" class="control-label"/>
            </div>
        </div>
    </spring:bind>
    <spring:bind path="customer.email">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input path="customer.email" type="email" class="form-control"
                            id="name" placeholder="Email"/>
                <form:errors path="customer.email" class="control-label"/>
            </div>
        </div>
    </spring:bind>
    <spring:bind path="customer.phone">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Phone</label>
            <div class="col-sm-10">
                <form:input path="customer.phone" type="phone" class="form-control"
                            id="name" placeholder="Name"/>
                <form:errors path="customer.phone" class="control-label"/>
            </div>
        </div>
    </spring:bind>
    <button type="submit" class="btn-lg btn-primary pull-right">Save</button>
</form:form>
</body>
</html>
