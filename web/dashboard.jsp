<%-- 
    Document   : dashboard
    Created on : Mar 9, 2023, 7:13:29 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Dashboard</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <link rel="stylesheet" href="css/admin.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
    </head>
    <body>
        <c:url var="logout" value="logoutAction">
        </c:url>
        <c:url var="stolkproducts" value="manageProductAction">
            <c:param name="filter" value="Low Stolk Products"></c:param>
        </c:url>
        <c:url var="manageproduct" value="manageProductAction">
            <c:param name="filter" value="Product"></c:param>
        </c:url>

        <c:url var="manageorders" value="manageOrdersAction">
            <c:param name="status" value="1"></c:param>
        </c:url> 
        <c:url var="manageordersinprogress" value="manageOrdersAction">
            <c:param name="status" value="2"></c:param>

        </c:url>
        <c:url var="manageorderscompleted" value="manageOrdersAction">
            <c:param name="status" value="3"></c:param>

        </c:url>
        <div class="container-fluid">
            <div class="row">
                <jsp:include page="sidebar.jsp"></jsp:include>
                    <div class="col-md-10 right">
                        <div class="shoptitle">
                            <h3 class="shoptitleh3">Dashboard</h3>
                            <div class="shoptitle-btn">
                                <p style="text-align: center; margin: auto 0; font-size: 1.6rem">
                                ${day}
                            </p>
                            <a class="shoptitle-item__logout" href="${logout}">
                                <i class="fa fa-door-open add-icon"></i>

                                Logout
                            </a>
                        </div>
                    </div>
                    <div class="dashboard">
                        <div class="row">
                            <div class="col-md-6">
                                <a  class="dasboard__item-link">
                                    <div class="dasboard__item">
                                        <div class="dashboard__sub-item">
                                            <h5 class="dashboard-title">Today Revenue</h5>
                                            <h6 class="dasboard-price">$${totalRevenueAtNow}</h6>
                                        </div>
                                        <div class="dashboard__sub-item">
                                            <i
                                                style="color: rgb(255, 87, 154)"
                                                class="fa fa-credit-card dashboard-icon"
                                                ></i>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-6">
                                <a  class="dasboard__item-link">
                                    <div class="dasboard__item">
                                        <div class="dashboard__sub-item">
                                            <h5 class="dashboard-title">Total Revenue</h5>
                                            <h6 class="dasboard-price">$${totalRevenue}</h6>
                                        </div>
                                        <div class="dashboard__sub-item">
                                            <i
                                                style="color: rgb(255, 87, 154)"
                                                class="fa fa-credit-card dashboard-icon"
                                                ></i>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <a href="${manageorders}" class="dasboard__item-link">
                                    <div class="dasboard__item">
                                        <div class="dashboard__sub-item">
                                            <h5 class="dashboard-title">Orders Volume</h5>
                                            <h6 class="dasboard-price">${orderCount}</h6>
                                        </div>
                                        <div class="dashboard__sub-item">
                                            <i
                                                style="color: rgb(255, 140, 0)"
                                                class="fa fa-shopping-cart dashboard-icon"
                                                ></i>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="${manageorders}" class="dasboard__item-link">
                                    <div class="dasboard__item">
                                        <div class="dashboard__sub-item">
                                            <h5 class="dashboard-title">Orders Pending</h5>
                                            <h6 class="dasboard-price">${totalOrdersPending}</h6>
                                        </div>
                                        <div class="dashboard__sub-item">
                                            <i
                                                style="color: rgb(255, 140, 0)"
                                                class="fa fa-shopping-cart dashboard-icon"
                                                ></i>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="${manageorderscompleted}" class="dasboard__item-link">
                                    <div class="dasboard__item">
                                        <div class="dashboard__sub-item">
                                            <h5 class="dashboard-title">Orders Completed</h5>
                                            <h6 class="dasboard-price">${totalOrdersCompleted}</h6>
                                        </div>
                                        <div class="dashboard__sub-item">
                                            <i
                                                style="color: rgb(255, 140, 0)"
                                                class="fa fa-shopping-cart dashboard-icon"
                                                ></i>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="row dashboard">
                        <div class="col-md-6">
                            <a href="${manageproduct}" class="dasboard__item-link">
                                <div class="dasboard__item">
                                    <div class="dashboard__sub-item">
                                        <h5 class="dashboard-title">Product</h5>
                                        <h6 class="dasboard-price">${totalProduct}</h6>
                                    </div>
                                    <div class="dashboard__sub-item">
                                        <i
                                            style="color: rgb(76, 172, 81)"
                                            class="fa fa-shopping-bag dashboard-icon"
                                            ></i>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a href="${stolkproducts}" class="dasboard__item-link">
                                <div class="dasboard__item">
                                    <div class="dashboard__sub-item">
                                        <h5 class="dashboard-title">Low Stolk Products</h5>
                                        <h6 class="dasboard-price">${countLowStokProducts}</h6>
                                    </div>
                                    <div class="dashboard__sub-item">
                                        <i
                                            style="color: rgb(223, 21, 38)"
                                            class="fa fa-exclamation-circle dashboard-icon"
                                            ></i>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
        <script src="js/shop.js"></script>
    </body>
</html>
