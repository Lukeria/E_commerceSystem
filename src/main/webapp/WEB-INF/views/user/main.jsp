<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">--%>
    <%--    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png">--%>
    <title>
        Main
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
        <div class="modal fade modal-black" id="exampleModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="exampleModalLabel">Have any questions?</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="tim-icons icon-simple-remove"></i>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="questionForm">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text text-primary">
                                            <i class="tim-icons icon-single-02"></i>
                                        </div>
                                    </div>
                                    <input type="email" class="form-control" id="name"
                                           placeholder="Introduce yourself">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text text-primary">
                                            <i class="tim-icons icon-email-85"></i>
                                        </div>
                                    </div>
                                    <input type="email" class="form-control" id="email"
                                           placeholder="Enter email">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text text-primary">
                                            <i class="tim-icons icon-notes"></i>
                                        </div>
                                    </div>
                                    <input type="password" class="form-control" id="topic"
                                           placeholder="Topic">
                                </div>
                            </div>
                            <div class="form-group">
                                    <textarea class="form-control" id="message" rows="3"
                                              placeholder="Message"></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary animation-on-hover">Send</button>
                    </div>
                </div>
            </div>
        </div>
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
                                <security:authorize access="!hasRole('ADMIN')">
                                    <li class="nav-item">
                                        <a class="nav-link" href="/calculator/">Calculate order</a>
                                    </li>
                                </security:authorize>
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
                        <security:authorize access="!hasRole('ADMIN')">
                            <li class="nav-item">
                                <a href="/main/#questionForm" class="btn btn-info btn-simple" data-toggle="modal"
                                   data-target="#exampleModal">Сall request</a>
                            </li>
                        </security:authorize>
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
                                    <security:authorize access="hasRole('ADMIN')">
                                        <li class="nav-link"><a href="/order/all"
                                                                class="nav-item dropdown-item">Admin dashboard</a>
                                        </li>
                                    </security:authorize>
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
                <div class="col">
                    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                                    class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                                    aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                                    aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${pageContext.request.contextPath}/resources/img/main1.jpg"
                                     class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3>Зеркальные композиции и зеркала</h3>
                                    <p>Изготовление под заказ, с доставкой и установкой</p>
                                    <a href="/catalog/" class="btn btn-warning animation-on-hover">Перейти в каталог</a>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img src="${pageContext.request.contextPath}/resources/img/main1.jpg"
                                     class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3>Стеклянные двери и перегородки</h3>
                                    <p>Изготовление под заказ, с доставкой и установкой</p>
                                    <a href="/catalog/" class="btn btn-warning animation-on-hover">Перейти в каталог</a>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img src="${pageContext.request.contextPath}/resources/img/main1.jpg"
                                     class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3>Душевые кабины из стекла</h3>
                                    <p>Изготовление под заказ, с доставкой и установкой</p>
                                    <a href="/catalog/" class="btn btn-warning animation-on-hover">Перейти в каталог</a>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                                data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Предыдущий</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                                data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Следующий</span>
                        </button>
                    </div>
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-lg-2">
                </div>
                <div class="col-lg-8">
                    <div class="card" style="margin-top: 2rem">
                        <div class="card-header">
                            <h1 class="card-title text-center">Glass Изделия из стекла</h1>
                        </div>
                        <div class="card-body">
                            <p class="card-text">Большой ассортимент зеркал, мебели, другой продукции из стекла на
                                заказ, которые придадут
                                оригинальность, неповторимость интерьеру!</p>
                            <p class="card-text">У нас особый подход к клиенту: любое изделие, которое Вы увидите на
                                нашем сайте, может быть
                                изготовлено в соответствии с Вашими пожеланиями.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                </div>
            </div>
            <div class="row align-items-center">
                <%--                <div class="col-lg-2">--%>
                <%--                </div>--%>
                <div class="col-lg-3 col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/mirror.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Card title</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                            <a href="#" class="btn btn-simple btn-primary btn-one">
                                <span>Перейти в каталог <i class="tim-icons icon-double-right"></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/wall.png"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Card title</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the
                                bulk of the card's content.</p>
                            <a href="#" class="btn btn-simple btn-primary btn-one">
                                <span>Перейти в каталог <i class="tim-icons icon-double-right"></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/shower.png"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Card title</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                            <a href="#" class="btn btn-simple btn-primary btn-one">
                                <span>Перейти в каталог <i class="tim-icons icon-double-right"></i></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/kitchen.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Card title</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the
                                bulk of the card's content.</p>
                            <a href="#" class="btn btn-simple btn-primary btn-one">
                                <span>Перейти в каталог <i class="tim-icons icon-double-right"></i></span>
                            </a>
                        </div>
                    </div>
                </div>

                <%--                <div class="col-lg-2">--%>
                <%--                </div>--%>
            </div>
            <div class="row align-items-center">
                <%--                <div class="col-lg-2">--%>
                <%--                </div>--%>
                <%--                <div class="col-lg-2">--%>
                <%--                </div>--%>
            </div>
            <div class="row align-items-center">
                <div class="col-lg-2">
                </div>
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title text-center">Наши преимущества</h3>
                        </div>
                        <div class="card-body">
                            <div class="row align-items-center">
                                <div class="col">
                                    <img
                                            src="${pageContext.request.contextPath}/resources/img/img.png"
                                            alt="Card image cap">
                                    <img
                                            src="${pageContext.request.contextPath}/resources/img/img_1.png"
                                            alt="Card image cap">
                                    <img
                                            src="${pageContext.request.contextPath}/resources/img/img_2.png"
                                            alt="Card image cap">
                                    <img
                                            src="${pageContext.request.contextPath}/resources/img/img_3.png"
                                            alt="Card image cap">
                                </div>
                            </div>
                            <p class="card-text text"><strong>Вы хотите придать интерьеру больше
                                индивидуальности?</strong></p>
                            <p class="card-text">Предлагаем оригинальные решения из стекла: полки, стеклянные
                                перегородки, зеркала любой формы.</p>
                            <p class="card-text">Скинали и стеклянные панно органично вписываются в кухню, матовая
                                душевая кабина — в ванную комнату, а гостиную можно украсить зеркалами с необычным
                                дизайном, а в спальню впишется шкаф-купе с узорчатой зеркальной поверхностью.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title text-center">Что мы делаем для своих клиентов</h3>
                        </div>
                        <div class="card-body">

                            <ul>
                                <li>Изготавливаем стеклянные изделия любых форм и размеров, массово или на заказ, по
                                    особому дизайну.
                                </li>
                                <li>Большой выбор материалов позволяет реализовать любые проекты.</li>
                                <li>Мы работаем как с масштабными проектами, так и индивидуальными, единичными
                                    заказами.
                                </li>
                                <li>Каждую вашу заявку мы выполним быстро.</li>
                                <li>Мы ожем выполнить услуги обработки стеклянных поверхностей: резку, сверление
                                    отверстий, матирование, закалку и многое другое. Любые работы мы проведем
                                    быстро, качественно.
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <div>
                        ©Copyright
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                    </div>
                    <div>
                        <p class="text-muted">Made with <i class="tim-icons icon-heart-2"></i></p>
                    </div>
                </div>
            </footer>
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
