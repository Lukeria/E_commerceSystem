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
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png">
    <title>
        STEKLO.BY
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
        <jsp:include page="${pageContext.request.contextPath}/resources/pagesToLoad/userHeader.jsp"/>
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
                                <img src="${pageContext.request.contextPath}/resources/img/main_wall.jpg"
                                     class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3>Стеклянные двери и перегородки</h3>
                                    <p>Изготовление под заказ, с доставкой и установкой</p>
                                    <a href="/catalog/" class="btn btn-warning animation-on-hover">Перейти в каталог</a>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img src="${pageContext.request.contextPath}/resources/img/main_mirror.jpg"
                                     class="d-block w-100" alt="...">
                                <div class="carousel-caption d-none d-md-block">
                                    <h3>Зеркальные композиции и зеркала</h3>
                                    <p>Изготовление под заказ, с доставкой и установкой</p>
                                    <a href="/catalog/" class="btn btn-warning animation-on-hover">Перейти в каталог</a>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img src="${pageContext.request.contextPath}/resources/img/main_shower.jpg"
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
                            <p class="card-text">Предлагаем оригинальные решения из стекла: полки, стеклянные
                                перегородки, зеркала любой формы.</p>
                            <p class="card-text">Скинали и стеклянные панно органично вписываются в кухню, матовая
                                душевая кабина — в ванную комнату, а гостиную можно украсить зеркалами с необычным
                                дизайном, а в спальню впишется шкаф-купе с узорчатой зеркальной поверхностью.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-lg-3 col-md-6">
                    <div class="card">
                        <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/mirror.jpg"
                             alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Зеркала с подстветкой</h4>
                            <a href="#" class="btn btn-simple btn-warning btn-one">
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
                            <h4 class="card-title">Перегородки из стекла</h4>
                            <a href="#" class="btn btn-simple btn-warning btn-one">
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
                            <h4 class="card-title">Душевые из стекла</h4>
                            <a href="#" class="btn btn-simple btn-warning btn-one">
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
                            <h4 class="card-title">Кухонные скинали</h4>
                            <a href="#" class="btn btn-simple btn-warning btn-one">
                                <span>Перейти в каталог <i class="tim-icons icon-double-right"></i></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-2">
                </div>
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title text-center">Наши преимущества</h3>
                        </div>
                        <div class="card-body">
                            <div class="row align-items-center mb-3">
                                <div class="col-2">
                                    <div class="card-text"><img
                                            src="${pageContext.request.contextPath}/resources/img/img_1.png"
                                            alt="Card image cap">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <h6 class="card-text">
                                        20 лет на рынке
                                    </h6>
                                    <p class="card-text">
                                        Наша компания на рынке около 20 лет
                                    </p>
                                </div>
                            </div>
                            <div class="row align-items-center mb-3">
                                <div class="col-2">
                                    <div class="card-text">
                                        <img src="${pageContext.request.contextPath}/resources/img/img.png"
                                             alt="Card image cap">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <h6 class="card-text">
                                        Минимальная наценка
                                    </h6>
                                    <p class="card-text">
                                        Мы не имеем диллеров и посредников, поэтому ценна продукции имеет минимальную
                                        наценку
                                    </p>
                                </div>
                            </div>
                            <div class="row align-items-center mb-3">
                                <div class="col-2">
                                    <div class="card-text">
                                        <img src="${pageContext.request.contextPath}/resources/img/img_2.png"
                                             alt="Card image cap">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <h6 class="card-text">
                                        Надежность и долговечность
                                    </h6>
                                    <p class="card-text">
                                        Установку изделий прозводят опытные специалисты, что гарантирует долговечность и
                                        прочность
                                    </p>
                                </div>
                            </div>
                            <div class="row align-items-center mb-3">
                                <div class="col-2">
                                    <div class="card-text">
                                        <img src="${pageContext.request.contextPath}/resources/img/img_3.png"
                                             alt="Card image cap">
                                    </div>
                                </div>
                                <div class="col-10">
                                    <h6 class="card-text">
                                        Качественная фурнитура
                                    </h6>
                                    <p class="card-text">
                                        Используем качественную фурнитуру мировых брендов
                                    </p>
                                </div>
                            </div>
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
            <div id="footerGroup">
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
<script src="${pageContext.request.contextPath}/resources/js/custom/bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#footerGroup").load("/resources/pagesToLoad/footer.html #footer");
    });
</script>
</body>
</html>
