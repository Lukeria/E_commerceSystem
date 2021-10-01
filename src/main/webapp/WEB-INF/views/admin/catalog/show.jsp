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
                <div class="col-lg-8 col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Card information
                            </h4>
                        </div>
                        <div class="card-body">
                            <input type="hidden" id="catalog_id" value="${catalog.id}">
                            <p class="text-left"><label>Product type: </label>
                                <span class="text-primary">${catalog.productType.representation}</span></p>
                            <h4 class="card-title" style="margin-top: 2.75rem">Glass
                            </h4>
                            <c:if test="${catalog.id!=null}">
                                <spring:url value="/catalog/settings/${catalog.id}/updateGlass" var="editUrl"/>
                            </c:if>
                            <a href="${editUrl}" class="btn btn-success btn-simple" id="updateGlass">Edit</a>
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
                                    <c:forEach var="glass" items="${catalog.glassList}" varStatus="status">
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
                <div class="col-lg-4 col-md-6">
                    <div class="card">
                        <spring:url value="/catalog/displayImage?id=${catalog.id}" var="imageUrl"/>

                        <img class="card-img-top"
                             src="${imageUrl}"
                             alt="Card image cap" id="my_image">
                        <div class="card-body">
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

<script src="${pageContext.request.contextPath}/resources/js/custom/catalog.js"></script>
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
