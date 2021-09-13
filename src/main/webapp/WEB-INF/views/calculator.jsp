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
    <div class="main-panel" data="green">
        <div id="navbar"></div>

        <div class="content">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Calculator</h4>
                </div>
                <div class="card-body">
                    <form id="calculatorForm" action="/order/create" method="post">
                        <div class="form-row">
                            <div class="form-group col-lg-6 col-md-12">
                                <label for="productType">Product type: </label>
                                <input type="text" id="productType" class="form-control" name="productType">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col">
                                <%--                                <h5><strong>Glass</strong></h5>--%>
                                <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                    <table class="table">
                                        <thead>
                                        <th>Glass</th>
                                        <th><button type="button" class="btn btn-primary btn-simple btn-sm" id="addRaw">Add</button></th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th>Processing</th>
                                        </thead>
                                        <tbody id="glass">
                                        <tr id="row_1">
                                            <td class="td-action">
                                                <button type="button" id="delete" type="button" rel="tooltip"
                                                        class="btn btn-link btn-danger btn-sm btn-icon">
                                                    <i class="tim-icons icon-trash-simple"></i>
                                                </button>
                                            </td>
                                            <td>
                                                <select class="form-control" id="glassType">
                                                </select>
                                            </td>
                                            <td>
                                                <select class="form-control" id="thickness">
                                                </select>
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" id="width" placeholder="Width">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" id="height" placeholder="Height">
                                            </td>
                                            <td class="td-action">
                                                <button type="button" id="addProcessing" type="button" rel="tooltip"
                                                        class="btn btn-link btn-success btn-sm btn-icon">
                                                    <i class="tim-icons icon-simple-add"></i>
                                                </button>
                                                <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                                    <table class="table table-borderless">
                                                        <tbody id="processing">
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </td>
                                        </tr>
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
                        <input id="tableJSON" type="hidden" name="tableJson">
                        <div class="form-row">
                            <div class="form-group col-lg-4 col-md-6">
                                <label for="result">Result:</label>
                                <security:authorize access="hasRole('ADMIN')">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="tim-icons icon-coins text-primary"></i>
                                        </div>
                                    </div>
                                    <input type="number" class="form-control" id="result" name="result">
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
                        <div class="form-row">
                            <div class="form-group col">
                                <button type="button" class="btn btn-primary" id="calculate">Calculate</button>
                                <security:authorize access="!hasRole('ADMIN')">
                                    <button type="button" class="btn btn-success" id="addToCart">Add to cart</button>
                                </security:authorize>
                                <security:authorize access="hasRole('ADMIN')">
                                    <button type="submit" class="btn btn-success" id="addOrder">Next</button>
                                </security:authorize>
                            </div>
                        </div>
                    </form>
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
        <security:authorize access="hasRole('ADMIN')">
        $("#sidebar").load("/resources/htmlToLoad/admin.html #sidebarAdmin");
        $("#navbar").load("/resources/htmlToLoad/admin.html #navbarAdmin");
        </security:authorize>
    });
</script>
</body>
</html>
