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
    <title>Calculator</title>
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
<body clas="">
<div class="wrapper">
    <div id="sidebar"></div>
    <div class="main-panel bg-image-main" data="green">
        <div id="navbar">
            <security:authorize access="!hasRole('ADMIN')">
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
            </security:authorize>
        </div>


        <security:authorize access="!hasRole('ADMIN')">
            <c:set var="contentClass" value="content-user"/>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <c:set var="contentClass" value="content"/>
        </security:authorize>
        <div class="${contentClass}">
            <div class="row">
                <security:authorize access="!hasRole('ADMIN')">
                    <div class="col-lg-2">
                    </div>
                    <c:set var="colSizeLg" value="col-lg-8"/>
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    <c:set var="colSizeLg" value="col-lg-12"/>
                </security:authorize>
                <div class="${colSizeLg} col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Calculator</h4>
                        </div>
                        <div class="card-body">
                            <form:form id="calculatorForm" method="post" action="/order/save" modelAttribute="order">
                                <c:if test="${order.id != null}">
                                    <div class="form-row">
                                        <div class="form-group col-lg-6">
                                            <p class="text-primary">Order #<span id="id">${order.id}</span></p>
                                            <form:input path="id" type="hidden"/>
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-lg-6">
                                            <p class="text-success">Customer: ${order.customer.name}</p>
                                        </div>
                                    </div>
                                </c:if>

                                <spring:bind path="productType">
                                    <div class="form-row">
                                        <div class="form-group col-lg-6 col-md-12">
                                            <label for="productType">Product type: </label>
                                            <div class="form-group ${status.error ? 'has-danger' : ''}">
                                                <form:input path="productType" type="text" id="productType"
                                                            class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                            name="productType"/>
                                            </div>
                                            <form:errors path="productType" class="form-text text-danger"/>
                                        </div>
                                    </div>
                                </spring:bind>

                                <div class="form-row">
                                    <div class="form-group col">
                                        <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                            <table class="table">
                                                <thead>
                                                <th>Glass</th>
                                                <th>
                                                    <button type="button" class="btn btn-primary btn-simple btn-sm"
                                                            id="addRaw">
                                                        Add
                                                    </button>
                                                </th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>Processing</th>
                                                </thead>
                                                <tbody id="glass">
                                                <c:forEach var="glass" items="${order.glassList}" varStatus="status">
                                                    <tr id="row_${status.count}">
                                                        <td class="td-action">
                                                            <button type="button" id="delete" type="button"
                                                                    rel="tooltip"
                                                                    class="btn btn-link btn-danger btn-sm btn-icon">
                                                                <i class="tim-icons icon-trash-simple"></i>
                                                            </button>
                                                        </td>
                                                        <td>
                                                            <select class="form-control" id="glassType">
                                                                <option selected
                                                                        value="${glass.glassType.name}">${glass.glassType.name}</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <select class="form-control" id="thickness">
                                                                <option selected
                                                                        value="${glass.glassType.id}">${glass.glassType.thickness}</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <input class="form-control" type="number" id="width"
                                                                   placeholder="Width" value="${glass.width}">
                                                        </td>
                                                        <td>
                                                            <input class="form-control" type="number" id="height"
                                                                   placeholder="Height" value="${glass.height}">
                                                        </td>
                                                        <td class="td-action">
                                                            <button type="button" id="addProcessing" type="button"
                                                                    rel="tooltip"
                                                                    class="btn btn-link btn-success btn-sm btn-icon">
                                                                <i class="tim-icons icon-simple-add"></i>
                                                            </button>
                                                            <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                                                <table class="table table-borderless">
                                                                    <tbody id="processing">
                                                                    <c:forEach var="processing"
                                                                               items="${glass.processingList}"
                                                                               varStatus="status">
                                                                        <tr id="row_${status.count}">
                                                                            <td class="td-action">
                                                                                <button type="button" id="delete"
                                                                                        type="button"
                                                                                        rel="tooltip"
                                                                                        class="btn btn-link btn-danger btn-sm btn-icon">
                                                                                    <i class="tim-icons icon-trash-simple"></i>
                                                                                </button>
                                                                            </td>
                                                                            <td>
                                                                                <select class="form-control" id="type">
                                                                                    <option selected
                                                                                            value="${processing.type}">${processing.type}</option>
                                                                                </select>
                                                                            </td>
                                                                            <td>
                                                                                <select class="form-control" id="name">
                                                                                    <option selected
                                                                                            value="${processing.id}">${processing.name}</option>
                                                                                </select>
                                                                            </td>
                                                                            <td>
                                                                                <input class="form-control"
                                                                                       type="number"
                                                                                       id="quantity"
                                                                                       placeholder="Quantity"
                                                                                       value="${processing.quantity}">
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <table>
                                    <tbody id="accessory">
                                    </tbody>
                                </table>
                                <table>
                                    <tbody id="extraService">
                                    </tbody>
                                </table>

                                <spring:bind path="cost">
                                    <div class="form-row">
                                        <div class="form-group col-lg-4 col-md-6">
                                            <label for="result">Result:</label>
                                            <security:authorize access="hasRole('ADMIN')">
                                                <div class="form-group ${status.error ? 'has-danger' : ''}">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <div class="input-group-text">
                                                                <i class="tim-icons icon-coins text-primary"></i>
                                                            </div>
                                                        </div>
                                                        <form:input path="cost" type="number"
                                                                    class="form-control ${status.error ? 'form-control-danger' : ''}"
                                                                    id="result"
                                                                    name="result"/>
                                                    </div>
                                                    <form:errors path="cost" class="form-text text-danger"/>
                                                </div>
                                            </security:authorize>
                                            <security:authorize access="!hasRole('ADMIN')">
                                                <h3>
                                                    <i class="tim-icons icon-coins text-primary"></i>
                                                    <span id="resultText"></span>
                                                </h3>
                                            </security:authorize>
                                        </div>
                                    </div>
                                </spring:bind>

                                <div class="form-row">
                                    <div class="form-group col">
                                        <button type="button" class="btn btn-primary animation-on-hover" id="calculate">Calculate</button>
                                        <security:authorize access="!hasRole('ADMIN')">
                                            <button type="button" class="btn btn-success animation-on-hover" id="addToCart">Add to cart
                                            </button>
                                        </security:authorize>
                                        <security:authorize access="hasRole('ADMIN')">
                                            <button type="submit" class="btn btn-success animation-on-hover" id="addOrder">Save</button>
                                        </security:authorize>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <security:authorize access="!hasRole('ADMIN')">
                <div class="col-lg-2">
                </div>
                </security:authorize>
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
<script src="${pageContext.request.contextPath}/resources/js/custom/calculator.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        <security:authorize access="hasRole('ADMIN')">
        $("#sidebar").load("/resources/htmlToLoad/admin.html #sidebarAdmin");
        $("#navbar").load("/resources/htmlToLoad/admin.html #navbarAdmin");
        </security:authorize>
    });
</script>
</body>
</html>
