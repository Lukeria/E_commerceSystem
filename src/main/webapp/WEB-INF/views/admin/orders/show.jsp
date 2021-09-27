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
    <title>Order</title>
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
    <div class="main-panel bg-image-main" data="green">
        <div id="navbar"></div>

        <div class="content">
            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>
            <div class="row">
                <div class="col-lg-8 col-md-12">
                    <div class="card card-plain">
                        <div class="card-header">
                            <h4 class="card-title">Order #${order.id}
                                <c:choose>
                                    <c:when test="${order.status.equals('Active')}">
                                        <span class="badge badge-pill badge-info">${order.status}</span>
                                    </c:when>
                                    <c:when test="${order.status.equals('Closed')}">
                                        <span class="badge badge-pill badge-danger">${order.status}</span>
                                    </c:when>
                                </c:choose>
                            </h4>
                        </div>
                        <div class="card-body">
                            <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                <table class="table tablesorter">
                                    <tbody>
                                    <tr>
                                        <td><label>Creation date:</label></td>
                                        <td class="text-left">${order.creationDateFormat}</td>
                                    </tr>
                                    <tr>
                                        <td><label>Deadline:</label></td>
                                        <td class="text-left">${order.deadlineFormat}</td>
                                    </tr>
                                    <tr>
                                        <td><label>Product type:</label></td>
                                        <td class="text-left">${order.productType}</td>
                                    </tr>
                                    <tr>
                                        <td><label class="text-primary">Cost:</label></td>
                                        <td class="text-left t"><span class="text-primary">${order.cost}</span></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Glass</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                <table class="table tablesorter">
                                    <thead>
                                    <tr>
                                        <th class="text-center">#</th>
                                        <th>Type</th>
                                        <th>Size</th>
                                        <th>Processing</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="glass" items="${order.glassList}" varStatus="status">
                                        <tr>
                                            <td class="text-center">${status.count}</td>
                                            <td>${glass.glassType.name}-${glass.glassType.thickness}</td>
                                            <td>${glass.width} x ${glass.height}</td>
                                            <td>
                                                <table class="table table-borderless">
                                                    <tbody>
                                                    <c:forEach var="processing" items="${glass.processingList}">
                                                        <tr>
                                                            <td>${processing.symbol}</td>
                                                            <td>${processing.quantity}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">
                                <i class="tim-icons icon-single-02 text-success"></i>
                                Customer contacts</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-full-width table-responsive table-wrapper-scroll-y my-custom-scrollbar">
                                <table class="table tablesorter">
                                    <tbody>
                                    <tr>
                                        <td><label>Name:</label></td>
                                        <td>${order.customer.name}</td>
                                    </tr>
                                    <tr>
                                        <td><label>Phone:</label></td>
                                        <td>${order.customer.phone}</td>
                                    </tr>
                                    <tr>
                                        <td><label>Email:</label></td>
                                        <td>${order.customer.email}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-md-12">

                </div>
            </div>
            <c:if test="${!order.status.equals('Closed')}">
                <div class="row">
                    <div class="col-lg-12">
                        <a href="/order/${order.id}/update" class="btn btn-success">Update</a>
                        <a href="/order/${order.id}/close" class="btn btn-primary" id="closeOrder">Mark as closed</a>
                    </div>
                </div>
            </c:if>
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

<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").load("/resources/htmlToLoad/admin.html #sidebarAdmin");
        $("#navbar").load("/resources/htmlToLoad/admin.html #navbarAdmin");

        $("#sidebar").ready(function () {
            $("#priceList").addClass("active");
        });
    });
</script>
</body>
</html>
