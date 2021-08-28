<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%--    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">--%>
<%--    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png">--%>
    <title>
        Admin
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/custom/black.css"/>
</head>
<body class="dark-content">
<div class="wrapper">
    <div class="sidebar">
        <!--
          Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
      -->
        <div class="sidebar-wrapper  bg-default rounded">
            <div class="logo">
                <a class="simple-text logo-normal">
                    Menu
                </a>
            </div>
            <ul class="nav">
                <li class="active">
                    <a href="/order/all">
                        <i class="tim-icons icon-chart-bar-32"></i>
                        <p>Orders</p>
                    </a>
                </li>
                <li>
                    <a href="/priceList/all">
                        <i class="tim-icons icon-paper"></i>
                        <p>Price lists</p>
                    </a>
                </li>
                <li>
                    <a href="/component/">
                        <i class="tim-icons icon-delivery-fast"></i>
                        <p>Warehouse</p>
                    </a>
                </li>
                <li>
                    <a href="/catalog/settings">
                        <i class="tim-icons icon-bag-16"></i>
                        <p>Catalog settings</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle d-inline">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="javascript:void(0)">Admin dashboard</a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse" id="navigation">
                    <ul class="navbar-nav ml-auto">
                        <!-- <li class="search-bar input-group">
                          <button class="btn btn-link" id="search-button" data-toggle="modal" data-target="#searchModal"><i class="tim-icons icon-zoom-split" ></i>
                            <span class="d-lg-none d-md-block">Search</span>
                          </button>
                        </li> -->
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
                                            <img src="${pageContext.request.contextPath}/resources/img/united-kingdom.png" alt="En">
                                        </div>
                                        English
                                    </a>
                                </li>
                                <li class="nav-link">
                                    <a href="javascript:void(0)" class="nav-item dropdown-item">
                                        <div class="photo">
                                            <img src="${pageContext.request.contextPath}/resources/img/russia.png" alt="Ru">
                                        </div>
                                        Russian
                                    </a>
                                </li>
                            </ul>
                        </li>
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
                                <li class="nav-link"><a href="javascript:void(0)" class="nav-item dropdown-item">Settings</a>
                                </li>
                                <li class="dropdown-divider"></li>
                                <li class="nav-link"><a href="/logout" class="nav-item dropdown-item">Log
                                    out</a></li>
                            </ul>
                        </li>
                        <li class="separator d-lg-none"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- <div class="modal modal-search fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="SEARCH">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <i class="tim-icons icon-simple-remove"></i>
                </button>
              </div>
            </div>
          </div>
        </div> -->
        <!-- End Navbar -->
        <div class="content">
            <div class="row">
                <div class="col-lg-8 col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title"> Active orders</h4>
                        </div>
                        <div class="card-body">
                            <div class="row tablePanel">
                                <a href="#" class="btn btn-success">Add order</a>
                                <form class="form-inline ml-auto" style="margin-top: 0; margin-bottom: 0">

                                    <button type="button" rel="tooltip"
                                            class="btn btn-success btn-link btn-sm btn-icon">
                                        <i class="tim-icons icon-bullet-list-67"></i>
                                    </button>
                                    <div class="form-group no-border" style="margin-top: 0.5rem; margin-bottom: 0.5rem">
                                        <input type="text" class="form-control" placeholder="Search">
                                    </div>
                                    <button type="submit" class="btn btn-link btn-icon btn-sm">
                                        <i class="tim-icons icon-zoom-split"></i>
                                    </button>
                                </form>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th class="text-center">#</th>
                                        <th>Name</th>
                                        <th>Product</th>
                                        <th>Date</th>
                                        <th class="text-right">Cost</th>
                                        <th class="text-right">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td class="text-center">1</td>
                                        <td>Andrew Mike</td>
                                        <td>Mirror</td>
                                        <td>20.08.21</td>
                                        <td class="text-right">99,22</td>
                                        <td class="td-actions text-right">
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-info btn-sm btn-icon">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </button>
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-success btn-sm btn-icon">
                                                <i class="tim-icons icon-pencil"></i>
                                            </button>
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-danger btn-sm btn-icon">
                                                <i class="tim-icons icon-simple-remove"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-center">2</td>
                                        <td>John Doe</td>
                                        <td>Shower cabin</td>
                                        <td>10.08.21</td>
                                        <td class="text-right">&euro; 89,24</td>
                                        <td class="td-actions text-right">
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-info btn-sm btn-icon">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </button>
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-success btn-sm btn-icon">
                                                <i class="tim-icons icon-pencil"></i>
                                            </button>
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-danger btn-sm btn-icon">
                                                <i class="tim-icons icon-simple-remove"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-center">3</td>
                                        <td>Alex Mike</td>
                                        <td>Glass</td>
                                        <td>13.08.21</td>
                                        <td class="text-right">92,14</td>
                                        <td class="td-actions text-right">
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-info btn-sm btn-icon">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </button>
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-success btn-sm btn-icon">
                                                <i class="tim-icons icon-pencil"></i>
                                            </button>
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-danger btn-sm btn-icon">
                                                <i class="tim-icons icon-simple-remove"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link page-arrow" href="#" aria-label="Previous">
                                            <i class="tim-icons icon-double-left"></i>
                                        </a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link page-arrow" href="#" aria-label="Next">
                                            <i class="tim-icons icon-double-right"></i>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="card card-plain">
                        <div class="card-header">
                            <h4 class="card-title"> Closed orders</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table tablesorter " id="">
                                    <thead class=" text-primary">
                                    <tr>
                                        <th>Name</th>
                                        <th>Product</th>
                                        <th class="text-right">Cost</th>
                                        <th class="text-right">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            Dakota Rice
                                        </td>
                                        <td>
                                            Mirror
                                        </td>
                                        <td class="text-right">
                                            $6,73
                                        </td>
                                        <td class="td-actions text-right">
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-info btn-sm btn-icon">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Minerva Hooper
                                        </td>
                                        <td>
                                            Mirror panel
                                        </td>
                                        <td class="text-right">
                                            $23,78
                                        </td>
                                        <td class="td-actions text-right">
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-info btn-sm btn-icon">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Sage Rodriguez
                                        </td>
                                        <td>
                                            Glass
                                        </td>
                                        <td class="text-right">
                                            $56,14
                                        </td>
                                        <td class="td-actions text-right">
                                            <button type="button" rel="tooltip"
                                                    class="btn btn-link btn-info btn-sm btn-icon">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col text-center">
                                    <a href="#" class="card-link">Load more</a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination justify-content-center">
                                            <li class="page-item">
                                                <a class="page-link page-arrow" href="#" aria-label="Previous">
                                                    <i class="tim-icons icon-double-left"></i>
                                                </a>
                                            </li>
                                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                                            <li class="page-item">
                                                <a class="page-link page-arrow" href="#" aria-label="Next">
                                                    <i class="tim-icons icon-double-right"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container-fluid">
                <ul class="nav">
                </ul>
            </div>
        </footer>
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
</body>

</html>
