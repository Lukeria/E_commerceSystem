<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">--%>
    <%--    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png">--%>
    <title>
        Sign up
    </title>
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
<body>
<div class="wrapper">
    <div class="main-panel bg-image">
        <div id="navbar"></div>
        <div class="row align-items-center" style="height: 100vh">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="card card-login">
                    <div class="card-body">
                        <form:form method="post" action="/signUp" modelAttribute="user">
                            <div class="form-row">
                                <spring:bind path="customer.name">
                                    <div class="form-group col-lg-8 col-md-12">
                                        <label for="login">Name: </label>
                                        <div class="form-group ${status.error ? 'has-danger' : ''}">
                                            <form:input path="customer.name" type="text" id="name" name="name"
                                                        class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                        placeholder="Enter name"/>
                                        </div>
                                        <form:errors path="customer.name" class="form-text text-danger"/>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="form-row">
                                <spring:bind path="email">
                                    <div class="form-group col-lg-6 col-md-12">
                                        <label for="email">Email: </label>
                                        <div class="form-group ${status.error ? 'has-danger' : ''}">
                                            <form:input path="email" type="email" id="email" name="email"
                                                        class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                        placeholder="Enter email"/>
                                        </div>
                                        <small id="help" class="form-text text-muted">We'll never share your data with
                                            anyone else.</small>
                                        <form:errors path="email" class="form-text text-danger"/>
                                    </div>
                                </spring:bind>
                                <spring:bind path="customer.phone">
                                    <div class="form-group col-lg-6 col-md-12">
                                        <label for="phone">Phone: </label>
                                        <div class="form-group ${status.error ? 'has-danger' : ''}">
                                            <form:input path="customer.phone" type="phone" id="phone" name="phone"
                                                        class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                        placeholder="Enter phone" aria-describedby="help"/>
                                            <form:errors path="customer.phone" class="form-text text-danger"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="form-row">
                                <spring:bind path="username">
                                    <div class="form-group col-lg-8 col-md-12">
                                        <label for="login">Login: </label>
                                        <div class="form-group ${status.error ? 'has-danger' : ''}">
                                            <form:input path="username" type="text" id="login" name="login"
                                                        class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                        placeholder="Enter login"/>
                                        </div>
                                        <form:errors path="username" class="form-text text-danger"/>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="form-row">
                                <spring:bind path="password">
                                    <div class="form-group col">
                                        <label for="password">Password: </label>
                                        <div class="form-group ${status.error ? 'has-danger' : ''}">
                                            <form:input path="password" type="password" id="password" name="password"
                                                        class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                        placeholder="Enter password"/>
                                        </div>
                                        <form:errors path="password" class="form-text text-danger"/>
                                    </div>
                                </spring:bind>
                                <spring:bind path="confirmPassword">
                                    <div class="form-group col">
                                        <label for="confirmPassword">Confirm password: </label>
                                        <div class="form-group ${status.error ? 'has-danger' : ''}">
                                            <form:input path="confirmPassword" type="password" id="confirmPassword"
                                                        class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                        placeholder="Confirm password"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <button type="submit" class="btn btn-warning animation-on-hover">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</div>
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/core/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/core/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!-- Chart JS -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script src="${pageContext.request.contextPath}/resources/js/black-dashboard.min.js?v=1.0.0"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#navbar").load("/resources/pagesToLoad/login.html #navbarLogin", function () {
            $('#englishIcon').attr("src", "${pageContext.request.contextPath}/resources/img/united-kingdom.png");
            $('#russianIcon').attr("src", "${pageContext.request.contextPath}/resources/img/russia.png");
        });
    });
</script>
</body>
</html>
