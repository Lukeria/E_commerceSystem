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
                <h4 class="modal-title" id="exampleModalLabel"><fmt:message key="message.navbar.modal.header"/></h4>
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
                            <fmt:message key="message.form.nameModal.placeHolder" var="namePlaceholder"/>
                            <input type="email" class="form-control" id="name"
                                   placeholder="${namePlaceholder}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text text-primary">
                                    <i class="tim-icons icon-email-85"></i>
                                </div>
                            </div>
                            <fmt:message key="message.form.email.placeHolder" var="emailPlaceholder"/>
                            <input type="email" class="form-control" id="email"
                                   placeholder="${emailPlaceholder}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text text-primary">
                                    <i class="tim-icons icon-mobile"></i>
                                </div>
                            </div>
                            <fmt:message key="message.form.phone.placeholder" var="phonePlaceholder"/>
                            <input type="text" class="form-control" id="phone"
                                   placeholder="${phonePlaceholder}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text text-primary">
                                    <i class="tim-icons icon-notes"></i>
                                </div>
                            </div>
                            <fmt:message key="message.form.topic.placeholder" var="topicPlaceholder"/>
                            <input type="text" class="form-control" id="topic"
                                   placeholder="${topicPlaceholder}">
                        </div>
                    </div>
                    <div class="form-group">
                        <fmt:message key="message.form.message.placeholder" var="messagePlaceholder"/>
                        <textarea class="form-control" id="message" rows="3"
                                  placeholder="${messagePlaceholder}"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary animation-on-hover" data-dismiss="modal"
                        aria-hidden="true"
                        <fmt:message key="message.notification.modalSend.success" var="modalNotification"/>
                        onclick="showNotification('${modalNotification}', 'success')"><fmt:message
                        key="message.navbar.modal.button.send"/>
                </button>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/main">STEKLO.BY</a>
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/main"><fmt:message
                                    key="message.navbar.section.home"/><span class="sr-only">(current)</span></a>
                        </li>
                        <security:authorize access="!hasRole('ADMIN')">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/calculator/"><fmt:message
                                        key="message.navbar.section.calculator"/></a>
                            </li>
                        </security:authorize>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/catalog/"><fmt:message
                                    key="message.navbar.section.catalog"/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/contacts"><fmt:message
                                    key="message.navbar.section.contacts"/></a>
                        </li>
                        <security:authorize access="hasRole('USER')">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/cart/"
                                   class="btn btn-primary btn-round animation-on-hover">
                                    <i class="tim-icons icon-cart"></i> <fmt:message key="message.navbar.button.cart"/>
                                </a>
                            </li>
                        </security:authorize>
                    </ul>
                </li>
                <li class="dropdown nav-item">
                    <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                        <i class="tim-icons icon-world"></i>
                        <p class="d-lg-none">
                            <fmt:message key="message.navbar.lang.heading"/>
                        </p>
                    </a>
                    <ul class="dropdown-menu dropdown-navbar">
                        <li class="nav-link">
                            <a href="?lang=en" class="nav-item dropdown-item">
                                <div class="photo">
                                    <img src="${pageContext.request.contextPath}/resources/img/united-kingdom.png"
                                         alt="En" id="englishIcon">
                                </div>
                                <fmt:message key="message.navbar.lang.en"/>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="?lang=ru" class="nav-item dropdown-item">
                                <div class="photo">
                                    <img src="${pageContext.request.contextPath}/resources/img/russia.png"
                                         alt="Ru" id="russianIcon">
                                </div>
                                <fmt:message key="message.navbar.lang.ru"/>
                            </a>
                        </li>
                    </ul>
                </li>
                <security:authorize access="!hasRole('ADMIN')">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/main/#questionForm" class="btn btn-info btn-simple"
                           data-toggle="modal"
                           data-target="#exampleModal"><fmt:message key="message.navbar.button.callRequest"/></a>
                    </li>
                </security:authorize>
                <security:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/login"
                           class="btn btn-primary btn-simple"><fmt:message key="message.navbar.button.logIn"/></a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/signUp"
                           class="btn btn-warning btn-simple"><fmt:message key="message.navbar.button.signUp"/></a>
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown nav-item">
                        <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                            <i class="tim-icons icon-single-02"></i>
                            <p class="d-lg-none">
                                <fmt:message key="message.navbar.button.user"/>
                            </p>
                        </a>
                        <ul class="dropdown-menu dropdown-navbar">
                            <li class="nav-link"><a href="${pageContext.request.contextPath}/profile/"
                                                    class="nav-item dropdown-item"><fmt:message
                                    key="message.navbar.button.profile"/></a></li>
                            <security:authorize access="hasRole('ADMIN')">
                                <li class="nav-link"><a href="${pageContext.request.contextPath}/order/all"
                                                        class="nav-item dropdown-item"><fmt:message
                                        key="message.navbar.button.adminDashboard"/></a>
                                </li>
                            </security:authorize>
                            <li class="dropdown-divider"></li>
                            <li class="nav-link"><a href="${pageContext.request.contextPath}/logout"
                                                    class="nav-item dropdown-item"> <fmt:message
                                    key="message.navbar.button.logOut"/></a></li>
                        </ul>
                    </li>
                </security:authorize>
                <li class="separator d-lg-none"></li>
            </ul>
        </div>
    </div>
</nav>
<script src="${pageContext.request.contextPath}/resources/js/custom/notification.js"></script>
</body>
</html>
