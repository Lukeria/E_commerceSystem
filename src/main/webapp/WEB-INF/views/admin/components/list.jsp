<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.e_commerceSystem.additional.ComponentTypes" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Components</title>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.6/css/all.css">
    <!-- Nucleo Icons -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/nucleo-icons.css"/>
    <!-- CSS Files -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom/custom.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/black-dashboard.css?v=1.0.0"/>
</head>
<body class="">
<div class="wrapper">
    <div id="sidebar"></div>
    <div class="main-panel" data="green">
        <div id="navbar"></div>

        <div class="content">
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">${componentType.representation}</h4>
                        </div>
                        <div class="card-body">
                            <div>
                                <spring:url value="/component/${componentType.name}/add" var="componentAddUrl" />
<%--                                <spring:url value="/component/add" var="componentAddUrl" />--%>
                                <a href="${componentAddUrl}" class="btn btn-success">Add</a>
                            </div>
                            <div class="table-full-width ps ps--active-y ps--scrolling-y">
                                <table class="table tablesorter">
                                    <thead>
                                    <tr>
                                        <c:if test="${componentType.name.equals('processing')}">
                                            <th>Type</th>
                                        </c:if>
                                        <th>Name</th>
                                        <c:if test="${componentType.name.equals('glassType')}">
                                            <th>Thickness</th>
                                        </c:if>
                                        <c:if test="${componentType.name.equals('processing')}">
                                            <th>Symbol</th>
                                        </c:if>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${componentList}" varStatus="counter">
                                        <tr>
                                            <td style="display:none;">${item.id}</td>
                                            <c:if test="${componentType.name.equals('processing')}">
                                                <td>${item.type}</td>
                                            </c:if>
                                            <td>${item.name}</td>
                                            <c:if test="${componentType.name.equals('glassType')}">
                                                <td>${item.thickness}</td>
                                            </c:if>
                                            <c:if test="${componentType.name.equals('processing')}">
                                                <td>${item.symbol}</td>
                                            </c:if>
                                            <td class="td-actions text-right">
                                                <spring:url value="/component/${componentType.name}/${item.id}/delete" var="deleteUrl" />
                                                <spring:url value="/component/${componentType.name}/${item.id}/update" var="updateUrl" />
                                                <button type="button" rel="tooltip"
                                                        class="btn btn-link btn-success btn-sm btn-icon"
                                                        onclick="location.href='${updateUrl}'">
                                                    <i class="tim-icons icon-pencil"></i>
                                                </button>
                                                <button type="button" rel="tooltip"
                                                        class="btn btn-link btn-danger btn-sm btn-icon"
                                                        onclick="post('${deleteUrl}')">
                                                    <i class="tim-icons icon-simple-remove"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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

<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").load("/resources/htmlToLoad/admin.html #sidebarAdmin", function () {
            $("#componentSection").addClass("active");
        });
        $("#navbar").load("/resources/htmlToLoad/admin.html #navbarAdmin", function () {
            $('#englishIcon').attr("src", "${pageContext.request.contextPath}/resources/img/united-kingdom.png");
            $('#russianIcon').attr("src", "${pageContext.request.contextPath}/resources/img/russia.png");
        });
    });

    function post(path, params, method) {
        method = method || "post";

        var form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);

        for ( var key in params) {
            if (params.hasOwnProperty(key)) {
                var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", key);
                hiddenField.setAttribute("value", params[key]);

                form.appendChild(hiddenField);
            }
        }

        document.body.appendChild(form);
        form.submit();
    }
</script>
</body>
</html>
