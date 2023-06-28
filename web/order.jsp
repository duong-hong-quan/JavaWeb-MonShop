<%-- 
    Document   : order
    Created on : Mar 8, 2023, 5:40:15 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Order</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/order.css"/>
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/responsive.css"/>
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
<c:url var="orderview" value="orderViewAction">
</c:url>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="sidebar">
                <h3 class="list-siderbar-item">Information</h3>

                <ul class="siderbar-list">
                    <li class="">
                        <a class="sidebar-item" href="accountPage">Account</a>
                    </li>
                    <li class="">
                        <a class="sidebar-item" href="${orderview}">Order</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="col-md-9">
            <div class="container">
                <div class="status-bar">
                    <c:url var="pending" value="orderViewAction">
                        <c:param name="status" value="1"></c:param>
                    </c:url>
                    <c:url var="inprogress" value="orderViewAction">
                        <c:param name="status" value="2"></c:param>
                    </c:url>
                    <c:url var="completed" value="orderViewAction">
                        <c:param name="status" value="3"></c:param>
                    </c:url>
                    <a href="${pending}" class="status-bar__item">
                        <i class="fa fa-list-ol"></i>
                        <p>Pending (${orderPending})</p>
                    </a>
                    <a href="${inprogress}" class="status-bar__item">
                        <i class="fa fa-truck-moving"></i>
                        <p>In Progress (${orderInprogress})</p>
                    </a>
                    <a href="${completed}" class="status-bar__item">
                        <i class="fa fa-home"></i>
                        <p>Completed (${orderCompleted})</p>
                    </a>

                </div>
                <div class="table-responsive-sm table-responsive-md">
                    <table class="table table-hover">
                        <thead class="table-thead">
                        <tr>
                            <th class="text-center" scope="col">Order ID</th>

                            <th class="text-center" scope="col">Order day</th>
                            <th class="text-center" scope="col">Status</th>

                            <th class="text-center" scope="col">Total</th>
                            <th class="text-center" scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dto" items="${orders}" varStatus="counter">
                            <tr>
                                <td class="text-center">${counter.count}</td>

                                <td class="text-center">
                                    <p>${dto.orderDate}</p>
                                </td>
                                <td class="text-center">
                                    <p>${dto.orderStatus.status}</p>
                                </td>
                                <td class="text-center">
                                    <p>${dto.total}</p>
                                </td>

                                <td class="text-center">
                                    <form action="orderDetailsView" method="POST">
                                        <input type="hidden" name="orderid" value="${dto.id}"/>
                                        <input type="hidden" name="total" value="${dto.total}"/>
                                        <input type="hidden" name="status" value="${dto.orderStatus.status}"/>

                                        <input type="submit" value="View" class=" action-btn"/>
                                    </form>


                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

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
