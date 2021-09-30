<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<body>
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
                                    <i class="tim-icons icon-mobile"></i>
                                </div>
                            </div>
                            <input type="phone" class="form-control" id="phone"
                                   placeholder="Enter phone number">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text text-primary">
                                    <i class="tim-icons icon-notes"></i>
                                </div>
                            </div>
                            <input type="text" class="form-control" id="topic"
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
                <button type="submit" class="btn btn-primary animation-on-hover" data-dismiss="modal"
                        aria-hidden="true" onclick="showNotification('Your reqest has been sent successfully', 'success')">Send
                </button>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
    <div class="container-fluid">
        <a class="navbar-brand" href="/main">STEKLO.BY</a>
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
                           data-target="#exampleModal">Call request</a>
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
<script type="text/javascript">

    function showNotification(text, color) {
        $.notify({
            icon: "tim-icons icon-bell-55",
            message: text

        }, {
            type: color,
            timer: 8000,
            placement: {
                from: 'bottom',
                align: 'center'
            }
        });
    }
</script>
</body>
</html>
