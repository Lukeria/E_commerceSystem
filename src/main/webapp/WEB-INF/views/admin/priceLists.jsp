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
    <title>Price lists</title>
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
    <div class="bg-image-main main-panel">
        <div id="navbar"></div>

        <div class="content">
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Price lists</h3>
                        </div>
                        <div class="card-body">
                            <form id="priceListForm">
                                <div class="form-group col-lg-6 col-md-12">
                                    <label for="currency">1 USD = </label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text text-primary"
                                                  style="padding-top: 0; padding-bottom: 0">
                                                BYN
                                            </span>
                                        </div>
                                        <input id="currency" type="number" class="form-control" step="0.01">
                                    </div>
                                </div>
                                <div class="form-group col-lg-6 col-md-12">
                                    <div class="form-group">
                                        <label for="increasePercent">Increase per cent: </label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text text-primary"
                                                      style="padding-top: 0; padding-bottom: 0">
                                                    %
                                                </span>
                                            </div>
                                            <input id="increasePercent" type="number"
                                                   class="form-control" step="0.01">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="button" id="updatePrices" class="btn btn-primary animation-on-hover">Update prices
                                    </button>
                                    <button type="submit" class="btn btn-success animation-on-hover">Save</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div id="accordion" role="tablist" aria-multiselectable="true" class="card-collapse">
                        <div class="card">
                            <div class="card-header" role="tab" id="headingOne">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                   aria-expanded="true" aria-controls="collapseOne">
                                    <h4 class="card-title">Glass types <i class="tim-icons icon-minimal-down"></i></h4>
                                </a>
                            </div>
                            <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                                <div class="card-body">
                                    <div class="table-full-width table-responsive ps ps--active-y ps--scrolling-y">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Thickness</th>
                                                <th>Price (USD)</th>
                                                <th>Price (BYN)</th>
                                                <th>
                                                    <button type="button" class="btn btn-primary btn-simple btn-sm"
                                                            id="glass_selectAll">
                                                        Select all
                                                    </button>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody id="glass">
                                            <c:forEach var="item" items="${glassTypeList}" varStatus="counter">
                                                <tr>
                                                    <td style="display:none;" id="id_${counter.count}">${item.id}</td>
                                                    <td id="name_${counter.count}">${item.name}</td>
                                                    <td id="thickness_${counter.count}">${item.thickness}</td>
                                                    <td><input type="number" value="${item.priceUSD}"
                                                               class="form-control"
                                                               id="priceUSD_${counter.count}" onchange="setSelect(this.id)"></td>
                                                    <td><input type="number" value="${item.price}" class="form-control"
                                                               id="price_${counter.count}" onchange="setSelect(this.id)"></td>
                                                    <td>
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input class="form-check-input" type="checkbox"
                                                                       id="selected_${counter.count}">
                                                                <span class="form-check-sign"><span
                                                                        class="check"></span></span>
                                                            </label>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
<%--                                        <div class="ps__rail-x" style="left: 0px; bottom: -59px;">--%>
<%--                                            <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>--%>
<%--                                        </div>--%>
<%--                                        <div class="ps__rail-y" style="top: 59px; height: 410px; right: 0px;">--%>
<%--                                            <div class="ps__thumb-y" tabindex="0" style="top: 52px; height: 358px;"></div>--%>
<%--                                        </div>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" role="tab" id="headingTwo">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                                   aria-expanded="false" aria-controls="collapseTwo">
                                    <h4 class="card-title">Processing <i class="tim-icons icon-minimal-down"></i></h4>
                                </a>
                            </div>
                            <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                                <div class="card-body">
                                    <div class="table-full-width table-responsive ps ps--active-y ps--scrolling-y">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Price (USD)</th>
                                                <th>Price (BYN)</th>
                                                <th>
                                                    <button type="button" class="btn btn-primary btn-simple btn-sm"
                                                            id="processing_selectAll">
                                                        Select all
                                                    </button>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody id="processing">
                                            <c:forEach var="item" items="${processingList}" varStatus="counter">
                                                <tr>
                                                    <td style="display:none;" id="id_${counter.count}">${item.id}</td>
                                                    <td id="name_${counter.count}">${item.name}</td>
                                                    <td><input type="number" value="${item.priceUSD}"
                                                               id="priceUSD_${counter.count}" class="form-control"
                                                               onchange="setSelect(this.id)"></td>
                                                    <td><input type="number" value="${item.price}"
                                                               id="price_${counter.count}"
                                                               class="form-control" onchange="setSelect(this.id)">
                                                    </td>
                                                    <td>
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input class="form-check-input" type="checkbox"
                                                                       id="selected_${counter.count}">
                                                                <span class="form-check-sign"><span
                                                                        class="check"></span></span>
                                                            </label>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
<%--                                        <div class="ps__rail-x" style="left: 0px; bottom: -59px;">--%>
<%--                                            <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>--%>
<%--                                        </div>--%>
<%--                                        <div class="ps__rail-y" style="top: 59px; height: 410px; right: 0px;">--%>
<%--                                            <div class="ps__thumb-y" tabindex="0"--%>
<%--                                                 style="top: 52px; height: 358px;"></div>--%>
<%--                                        </div>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" role="tab" id="headingThree">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    <h4 class="card-title">Accessory <i class="tim-icons icon-minimal-down"></i></h4>
                                </a>
                            </div>
                            <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
                                <div class="card-body">
                                    <div class="table-full-width table-responsive ps ps--active-y ps--scrolling-y">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Price (USD)</th>
                                                <th>Price (BYN)</th>
                                                <th>
                                                    <button type="button" class="btn btn-primary btn-simple btn-sm"
                                                            id="accessory_selectAll">
                                                        Select all
                                                    </button>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody id="accessory">
                                            <c:forEach var="item" items="${accessoryList}" varStatus="counter">
                                                <tr>
                                                    <td style="display:none;" id="id_${counter.count}">${item.id}</td>
                                                    <td id="name_${counter.count}">${item.name}</td>
                                                    <td><input type="number" value="${item.priceUSD}"
                                                               id="priceUSD_${counter.count}" class="form-control"
                                                               onchange="setSelect(this.id)"></td>
                                                    <td><input type="number" value="${item.price}"
                                                               id="price_${counter.count}" onchange="setSelect(this.id)"
                                                               class="form-control">
                                                    </td>
                                                    <td>
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input class="form-check-input" type="checkbox"
                                                                       id="selected_${counter.count}">
                                                                <span class="form-check-sign"><span
                                                                        class="check"></span></span>
                                                            </label>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
<%--                                        <div class="ps__rail-x" style="left: 0px; bottom: -59px;">--%>
<%--                                            <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>--%>
<%--                                        </div>--%>
<%--                                        <div class="ps__rail-y" style="top: 59px; height: 410px; right: 0px;">--%>
<%--                                            <div class="ps__thumb-y" tabindex="0" style="top: 52px; height: 358px;"></div>--%>
<%--                                        </div>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div><p id="successMessage"></p></div>
            <div id="footerGroup"></div>
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

<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom/priceLists.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#sidebar").load("/resources/pagesToLoad/admin.html #sidebarAdmin", function () {
            $("#priceListSection").addClass("active");
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
