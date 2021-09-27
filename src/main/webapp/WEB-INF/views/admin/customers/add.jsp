<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Customer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" \>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.6/css/all.css">
    <!-- Nucleo Icons -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/nucleo-icons.css"/>
    <!-- CSS Files -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/black-dashboard.css?v=1.0.0"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom/custom.css"/>
</head>
<body class="">
<div class="wrapper">
    <div id="sidebar"></div>
    <div class="bg-image-main main-panel" data="green">
        <div id="navbar"></div>

        <div class="content">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Customer information</h4>
                </div>
                <div class="card-body">
                    <spring:url value="/customer/saveOrderCustomer" var="orderAdd"/>
                    <form:form method="post" action="${orderAdd}" modelAttribute="customer">
                        <input name="orderId" type="hidden" class="form-control" id="id" value="${orderId}"/>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <form:input path="name" type="text" class="form-control" id="name"
                                            placeholder="Enter first and last name"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email address:</label>
                                <form:input path="email" type="email" class="form-control" id="email"
                                            aria-describedby="emailHelp" placeholder="Enter email"/>
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with
                                    anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone:</label>
                                <form:input path="phone" type="phone" class="form-control" id="phone"
                                            placeholder="Enter phone number"/>
                            </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/core/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/core/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->
<!-- Place this tag in your head or just before your close body tag. -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chart JS -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script src="${pageContext.request.contextPath}/resources/js/black-dashboard.min.js?v=1.0.0"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom/calculator.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").load("/resources/htmlToLoad/admin.html #sidebarAdmin");
        $("#navbar").load("/resources/htmlToLoad/admin.html #navbarAdmin");
    });
</script>
</body>
</html>
