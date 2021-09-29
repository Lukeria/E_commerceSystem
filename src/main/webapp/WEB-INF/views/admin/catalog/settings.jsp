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
    <title>Catalog settings</title>
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
    <div id="sidebar"></div>
    <div class="bg-image-main main-panel">
        <div id="navbar"></div>

        <div class="content">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Catalog settings</h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-2 col-md-3 col-sm-4">
                                    <a href="/catalog/settings/add" class="btn btn-success animation-on-hover">Add</a>
                                </div>
                                <div class="col-lg-10 col-md-9 col-sm-8">
                                    <ul class="nav nav-tabs justify-content-end">
                                        <c:forEach var="type" items="${productTypes}" varStatus="status">
                                            <c:if test="${status.index==0}">
                                                <c:set var="active" value="active"/>
                                            </c:if>
                                            <c:if test="${status.index!=0}">
                                                <c:set var="active" value=""/>
                                            </c:if>
                                            <li class="nav-item">
                                                <a class="nav-link btn-primary btn-link ${active}"
                                                   href="#collapseExample" data-toggle="collapse" aria-expanded="false"
                                                   aria-controls="collapseExample">${type.representation}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="collapse show" id="collapseExample">
                        <div class="card card-plain">
                            <div class="card-body">
                                <div class="row">

                                    <c:forEach items="${listOfItems}" var="catalogItem">
                                        <spring:url value="/catalog/settings/${catalogItem.id}" var="updateUrl"/>
                                        <spring:url value="/catalog/settings/${catalogItem.id}/delete" var="deleteUrl"/>

                                        <div class="col-lg-2 col-md-3 col-sm-4">
                                            <div class="card">
                                                <img class="card-img-top"
                                                     src="/catalog/settings/displayImage?id=${catalogItem.id}"
                                                     alt="Card image cap">
                                                <div class="card-body">
                                                    <div class="card-text text-right">
                                                        <span class="badge badge-info"><i
                                                                class="tim-icons icon-tag"></i></span>
                                                        <a href="${updateUrl}"
                                                           class="btn btn-success btn-link btn-icon animation-on-hover">
                                                            <i class="tim-icons icon-pencil"></i>
                                                        </a>
                                                        <button onclick="post('${deleteUrl}')"
                                                           class="btn btn-danger btn-link btn-icon animation-on-hover">
                                                            <i class="tim-icons icon-trash-simple"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
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
<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").load("/resources/pagesToLoad/admin.html #sidebarAdmin", function () {
            $("#catalogSection").addClass("active");
        });
        $("#navbar").load("/resources/pagesToLoad/admin.html #navbarAdmin", function () {
            $('#englishIcon').attr("src", "${pageContext.request.contextPath}/resources/img/united-kingdom.png");
            $('#russianIcon').attr("src", "${pageContext.request.contextPath}/resources/img/russia.png");
        });
        $("#footerGroup").load("/resources/pagesToLoad/footer.html #footer");
    });

</script>
</body>
</html>
