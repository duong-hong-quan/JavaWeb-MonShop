<%-- 
    Document   : header.jsp
    Created on : Mar 6, 2023, 7:44:32 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="logout" value="logoutAction">
        </c:url>
        <c:url var="dashboard" value="dashboardPage">

        </c:url>
        <c:url var="searchProduct" value="filterProductAction">
            <c:param name="btAction" value="Filter Products"></c:param>

            <c:param name="filter" value="Search Products"></c:param>
        </c:url>
        <header id="header" class="header header_pc">
            <div style="background-color: #fafafa">
                <div class="container">
                    <div class="info">
                        <div class="info-sub">
                            <div class="info-sub_item info-sub_item__first">
                                <i class="fa fa-mobile-alt"></i>
                                <p>(+84) 366 967 957</p>
                            </div>

                            <div class="info-sub_item">
                                <i class="fa fa-envelope"></i>
                                <p>monshop.company@gmail.com</p>
                            </div>
                        </div>
                        <div class="info-sub">
                            <c:if test="${sessionScope.account != null}">
                                <div class="info-sub_item">
                                    <a >Welcome, ${sessionScope.account.fullname}</a>
                                </div>
                            </c:if>


                            <c:if test="${sessionScope.account == null}">
                                <div class="info-sub_item">
                                    <a href="signupPage" >Register</a>
                                </div>
                            </c:if>


                            <div class="info-sub_item info-sub_item__last">
                                <!-- <div class="info-sub_item">
                                  <a href="signup.html">Login</a>
                                </div> -->
                                <!-- <a href="">
                                  Sign in</a> -->
                                <c:if test="${sessionScope.account == null}">
                                    <a href="loginPage">Login</a>

                                </c:if>
                                <c:if test="${sessionScope.account != null}">
                                    <div class="dropdown">
                                        <i
                                            style="border: none; background: #fafafa"
                                            class="fa fa-user dropdown-toggle"
                                            ></i>
                                        <div class="dropdown-content">
                                            <a href="accountPage">Account</a>
                                            <c:if test="${sessionScope.account.role.id == 1}">

                                                <a href="dashboardView">Manage</a>

                                            </c:if>    

                                            <a href="${logout}">Log out</a>
                                        </div>
                                    </div>
                                </c:if>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="header_container">
                    <div class="logo">
                        <a class="logo__title" href="viewShop">Mon shop</a>
                        <button onclick="openmenu()" class="bar-icon" id="bar-icon">
                            <i class="fa fa-align-justify"></i>
                        </button>
                        <button
                            onclick="closemenu()"
                            class="closebar-icon"
                            id="closebar-icon"
                            >
                            <i class="fa fa-times"></i>
                        </button>
                        <div class="navbar-search">
                            <form action="${searchProduct}">
                                <input
                                    type="text"
                                    class="navbar-search__input"
                                    placeholder="Search product..."
                                    name="txtSearch"
                                    value="${requestScope.txtSearch}"
                                    />
                                <input type="hidden" name="filter" value="Search Products"  />

                                <button class="search-btn" type="submit" >
                                    <i class="fa fa-search"></i>
                                </button>
                            </form>
                        </div>
                    </div>

                    <div class="cart">
                        <c:set var="cart" value="${sessionScope.CART}"/>
                        <c:set var="countItem" value="${cart.getTotalItem()}" ></c:set>
                        <c:if test="${cart == null}">
                            <c:set var="countItem" value="0" ></c:set>

                        </c:if>
                        <c:url var="viewcart" value="viewCartPage">
                        </c:url>
                        <a href="${viewcart}">
                            <i class="fa fa-shopping-cart"></i>
                            <c:if test="${cart == null}}"></c:if>
                            Cart (${countItem})</a
                        >
                    </div>
                </div>
            </div>
            <div class="nav-link">
                <div class="container">
                    <nav class="navbar">
                        <ul class="nav navbar-nav">

                            <li><a class="navbar-nav__link  navbar-nav__link-first" href="viewShop">Shop</a></li>
                            <li>
                                <a class="navbar-nav__link" href="contact.jsp">Contact</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <header class="header header-md">
            <div style="background-color: #fafafa">
                <div class="container">
                    <div class="info">
                        <div class="info-sub info-sub-rs">
                            <div class="info-sub_item info-sub_item__first">
                                <i class="fa fa-mobile-alt"></i>
                                <p>(+84) 999 999</p>
                            </div>

                            <div class="info-sub_item">
                                <i class="fa fa-envelope"></i>
                                <p>duonghongquan0312@gmail.com</p>
                            </div>
                        </div>
                        <div class="info-sub">
                            <c:if test="${sessionScope.account != null}">
                                <div class="info-sub_item">
                                    <a >Welcome, ${sessionScope.account.fullname}</a>
                                </div>
                            </c:if>


                            <c:if test="${sessionScope.account == null}">
                                <div class="info-sub_item">
                                    <a href="signupPage" >Register</a>
                                </div>
                            </c:if>

                            <div class="info-sub_item info-sub_item__last">
                                <!-- <a href="">
                                  Sign in</a> -->
                                <div class="dropdown">
                                    <i
                                        style="border: none; background: #fafafa"
                                        class="fa fa-user dropdown-toggle"
                                        ></i>
                                    <div class="dropdown-content">
                                        <a href="accountPage">Account</a>
                                        <c:if test="${sessionScope.account.role.id == 1}">
                                            <a href="${dashboard}">Manage</a>

                                        </c:if>
                                        <a href="${logout}">Log out</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="header-container">
                    <div class="logo">
                        <a class="logo__title" href="viewShop">Mon shop</a>

                        <div class="cart">
                            <a href="${viewcart}">
                                <i class="fa fa-shopping-cart"></i>

                                Cart
                            </a>
                            <span>    </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="navbar-search navbar-search-md">
                    <form action="${searchProduct}">
                        <input
                            type="text"
                            class="navbar-search__input"
                            placeholder="Search product..."
                            name="txtSearch"
                            value="${requestScope.txtSearch}"

                            />

                        <button class="search-btn" type="submit" >
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>
            <div class="nav-link">
                <div class="container">
                    <nav class="navbar">
                        <ul class="nav navbar-nav">

                            <li><a class="navbar-nav__link navbar-nav__link-first" href="viewShop">Shop</a></li>
                            <li>
                                <a class="navbar-nav__link" href="contact.jsp">Contact</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>  
    </body>
</html>
