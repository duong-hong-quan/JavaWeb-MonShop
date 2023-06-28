<%-- 
    Document   : sidebar
    Created on : Mar 9, 2023, 7:14:13 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div class="col-md-2">
    <div class="header__admin">
        <img
                class="rounded-circle img-table"
                style="margin-top: 2rem"
                src="${sessionScope.account.image}"
                alt=""
        />
        <h3 class="user">Hello</h3>
        <p style="font-size: 2rem"> ${sessionScope.account.fullname}!</p>

        <button class="bar-icon" onclick="opennavbar()" id="bar-icon">
            <i class="fa fa-align-justify"></i>
        </button>

        <button
                class="closebar-icon"
                onclick="closenavbar()"
                id="closebar-icon"
        >
            <i class="fa fa-times"></i>
        </button>
    </div>
    <c:url var="dashboard" value="dashboardView">

    </c:url>
    <c:url var="manageproduct" value="manageProductAction">
        <c:param name="filter" value="Product"></c:param>
    </c:url>
    <c:url var="user" value="manageUserAction">


    </c:url>
    <c:url var="orders" value="manageOrdersAction">

        <c:param name="status" value="1"></c:param>

    </c:url>
    <c:url var="logout" value="logoutAction">


    </c:url>
    <div class="navbar__monshop" id="navbar">
        <ul class="navbar-component">
            <li>
                <a class="navbar__link" href="${dashboard}">
                    <i class="fa fa-tachometer-alt add-icon"></i>
                    <p>Dashboard</p></a
                >
            </li>
            <li>
                <a class="navbar__link" href="${manageproduct}">
                    <i class="fa fa-shopping-basket add-icon"></i>
                    <p>Product</p></a
                >
            </li>
            <li>
                <a class="navbar__link" href="${user}">
                    <i class="fa fa-user add-icon"></i>
                    <p>User</p></a
                >
            </li>
            <li>
                <a class="navbar__link" href="${orders}">
                    <i class="fa fa-shopping-bag add-icon"></i>
                    <p>Order</p></a
                >
            </li>

            <li>
                <a class="navbar__link navbar__link__logout" href="${logout}">
                    <i class="fa fa-door-open add-icon"></i>
                    <p>Logout</p></a
                >
            </li>
        </ul>
    </div>
</div>
</body>
</html>
