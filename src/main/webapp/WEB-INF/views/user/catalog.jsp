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
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon.png"/>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png"/>
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
</head>
<body>
<div class="wrapper">
    <div class="main-panel bg-image-main">
        <div class="modal fade modal-black" id="photoShowModal" tabindex="-1" role="dialog"
             aria-labelledby="photoShowModalLabel" aria-hidden="true" style="z-index: 2000; pointer-events: none">
            <div class="modal-dialog" role="document" style="transform: none; pointer-events: none">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="exampleModalLabel">${productType.representation}</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="tim-icons icon-simple-remove"></i>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="card">
                            <img class="card-img-top" src="" alt="Card image cap" id="openedPhoto">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="${pageContext.request.contextPath}/resources/pagesToLoad/userHeader.jsp"/>
        <div class="content-user">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <nav aria-label="breadcrumb" role="navigation">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a class="btn-primary btn-link" href="/main">Home</a></li>
                            <li class="breadcrumb-item" aria-current="page">Catalog</li>
                            <li class="breadcrumb-item active" aria-current="page">${productType.representation}</li>
                        </ol>
                    </nav>
                </div>
                <div class="col-lg-2"></div>
            </div>
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">${productType.representation}</h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-9 col-md-8">
                                    <p class="card-text">
                                        <c:choose>
                                            <c:when test="${productType.name.equals('mirror')}">
                                                Зеркала – многофункциональные элементы интерьера. Они сочетают две основные
                                                функции: практическую и декоративную. С их помощью можно преобразить помещение,
                                                добиться интересных оптических эффектов. Сделать заказ можно по телефону или
                                                посредством онлайн-формы.
                                            </c:when>
                                            <c:when test="${productType.name.equals('partition')}">
                                                Стеклянные перегородки – это не только способ зонирования пространства,
                                                но и элемент декора. Они могут визуально расширить помещение и увеличить
                                                световой поток. Сделать заказ можно по телефону или посредством онлайн-формы.
                                            </c:when>
                                            <c:when test="${productType.name.equals('shower')}">
                                                Душевые кабины из стекла прекрасно решают вопросы, связанные с качеством,
                                                удобством, функциональностью ванной комнаты. Они позволяют устранить тесноту,
                                                однообразие, реализовать самые интересные дизайнерские задумки в интерьере комнаты.
                                                Сделать заказ можно по телефону или посредством онлайн-формы.
                                            </c:when>
                                            <c:when test="${productType.name.equals('apron')}">
                                                Появление скинали позволило пересмотреть подходы к оформлению кухонного интерьера.
                                                Фартук для кухни из стекла не просто стал популярным интерьерным решением.
                                                Сделать заказ можно по телефону или посредством онлайн-формы.
                                            </c:when>
                                            <c:otherwise>
                                                Undefined
                                            </c:otherwise>
                                        </c:choose>
                                    </p>
                                </div>
                                <div class="col-lg-3 col-md-4 text-center">
                                    <spring:url
                                            value="${pageContext.request.contextPath}/calculator/?productType=${productType.name}"
                                            var="calculatorUrl">
                                    </spring:url>
                                    <a class="btn btn-primary animation-on-hover"
                                       href="${calculatorUrl}">Calculate order
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2"></div>
            </div>
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-2 col-md-12">
                    <div class="card card-nav-tabs">
                        <a class="btn btn-warning animation-on-hover" data-toggle="collapse"
                           href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            <i class="tim-icons icon-align-center"></i> Catalog
                        </a>
                        <div class="collapse show" id="collapseExample">
                            <div class="card-body">
                                <ul class="list-group list-group-flush">
                                    <a href="/catalog/mirror" class="btn btn-simple btn-warning">
                                        Зеркала
                                    </a>
                                    <a href="/catalog/partition" class="btn btn-simple btn-warning">
                                        Перегородки
                                    </a>
                                    <a href="/catalog/shower" class="btn btn-simple btn-warning">
                                        Душевые
                                    </a>
                                    <a href="/catalog/apron" class="btn btn-simple btn-warning">
                                        Кухонные скинали
                                    </a>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <c:forEach items="${listOfItems}" var="catalogItem" varStatus="status">
                            <div class="col-lg-4 col-md-4">
                                <div class="card">
                                    <img class="card-img-top"
                                         src="/catalog/displayImage?id=${catalogItem.id}"
                                         alt="Card image cap">
                                    <div class="card-body">
                                        <div class="card-text text-right">
                                            <spring:url
                                                    value="${pageContext.request.contextPath}/calculator/fillByCatalog/${catalogItem.id}"
                                                    var="fillOrderUrl">
                                            </spring:url>

                                            <a href="#" data-toggle="modal" data-target="#photoShowModal"
                                               class="btn btn-info btn-fab btn-icon btn-round animation-on-hover"
                                               onclick="openImage(this)">
                                                <i class="tim-icons icon-tap-02"></i>
                                            </a>

                                            <c:if test="${catalogItem.glassList.size()!=0}">
                                                <a href="${fillOrderUrl}"
                                                   class="btn btn-primary btn-fab btn-icon btn-round animation-on-hover">
                                                    <i class="tim-icons icon-cart"></i>
                                                </a>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-2"></div>
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

<script type="text/javascript">
    $(document).ready(function () {
        $("#footerGroup").load("/resources/pagesToLoad/footer.html #footer");

    });

    function openImage(element) {

        let currentCard = $(element).parents(".card");
        let imageSrc = $(currentCard).find('img').attr('src');
        $('#openedPhoto').attr('src', imageSrc);
    }
</script>
</body>
</html>
