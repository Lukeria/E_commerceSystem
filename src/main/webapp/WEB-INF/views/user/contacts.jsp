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
        Contacts
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
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/custom/carousel.css"/>
</head>
<body>
<div class="wrapper">
    <div class="main-panel bg-image-main">
        <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">STEKLO.BY</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse" id="navigation">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <a class="nav-link" href="/main">Home<span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/calculator/">Calculate order</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/catalog/">Catalog</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/contacts">Contacts</a>
                                </li>
                                <security:authorize access="hasRole('USER')">
                                    <li class="nav-item">
                                        <a href="/cart/"
                                           class="btn btn-primary btn-fab btn-icon btn-round animation-on-hover">
                                            <i class="tim-icons icon-cart"></i>
                                        </a>
                                    </li>
                                </security:authorize>
                            </ul>
                        </li>
                        <li class="dropdown nav-item">
                            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                                <i class="tim-icons icon-world"></i>
                                <p class="d-lg-none">
                                    Language
                                </p>
                            </a>
                            <ul class="dropdown-menu dropdown-navbar">
                                <li class="nav-link">
                                    <a href="javascript:void(0)" class="nav-item dropdown-item">
                                        <div class="photo">
                                            <img src="${pageContext.request.contextPath}/resources/img/united-kingdom.png"
                                                 alt="En" id="englishIcon">
                                        </div>
                                        English
                                    </a>
                                </li>
                                <li class="nav-link">
                                    <a href="javascript:void(0)" class="nav-item dropdown-item">
                                        <div class="photo">
                                            <img src="${pageContext.request.contextPath}/resources/img/russia.png"
                                                 alt="Ru" id="russianIcon">
                                        </div>
                                        Russian
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a href="/main/#questionForm" class="btn btn-info btn-simple">Сall request</a>
                        </li>
                        <security:authorize access="!isAuthenticated()">
                            <li class="nav-item">
                                <a href="/login" class="btn btn-primary btn-simple">Log in</a>
                            </li>
                            <li class="nav-item">
                                <a href="/signUp" class="btn btn-warning btn-simple">Sign up</a>
                            </li>
                        </security:authorize>
                        <security:authorize access="isAuthenticated()">
                            <li class="dropdown nav-item">
                                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                                    <i class="tim-icons icon-single-02"></i>
                                    <p class="d-lg-none">
                                        Log out
                                    </p>
                                </a>
                                <ul class="dropdown-menu dropdown-navbar">
                                    <li class="nav-link"><a href="/profile/"
                                                            class="nav-item dropdown-item">Profile</a></li>
                                    <li class="nav-link"><a href="javascript:void(0)"
                                                            class="nav-item dropdown-item">Settings</a>
                                    </li>
                                    <li class="dropdown-divider"></li>
                                    <li class="nav-link"><a href="/logout" class="nav-item dropdown-item">Log
                                        out</a></li>
                                </ul>
                            </li>
                        </security:authorize>
                        <li class="separator d-lg-none"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="content-user">
            <div class="row align-items-center">
                <div class="col-lg-2">
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="card">
                        <div class="card-body">
                                <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A6b0a9c2451ef923858442f47e705a14f0a4ba7bef5952126db1339304821ecf5&amp;source=constructor"
                                        width="460" height="400" frameborder="0"></iframe>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Our contacts</h4>
                        </div>
                        <div class="card-body">
                            <p class="card-text">Время работы: 10:00-17:00</p>
                            <p class="card-text">Выходные: Понедельник</p>
                            <p class="card-text">Адрес: г.Минск, ул.Уручская, Строительный рынок "Уручье"</p>
                            <p class="card-text">Телефоны:</p>
                            <p class="card-text">A1 +375 (44) 782-50-19</p>
                            <p class="card-text">MTC +375 (29) 708-76-93</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
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
<!-- Chart JS -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
<script src="${pageContext.request.contextPath}/resources/js/black-dashboard.min.js?v=1.0.0"></script>
<!-- Black Dashboard DEMO methods, don't include it in your project! -->
<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/js/custom/bootstrap.js"/>

<script type="text/javascript">

</script>

</body>
</html>
