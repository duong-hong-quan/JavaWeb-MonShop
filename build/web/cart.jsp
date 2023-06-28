<%-- 
    Document   : cart
    Created on : Mar 7, 2023, 5:10:12 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="quandh.cart.CartObj" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Cart</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/cart.css"/>
    <link rel="stylesheet" href="css/responsive.css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<c:set var="cart" value="${sessionScope.CART}"/>

<c:url var="checkout" value="checkOutAction">
</c:url>
<div class="container">
    <a class="shoppingcart_title">Shopping cart</a>
    <!-- <a style="font-size: 1.6rem" href="shop.html">Back to shop</a> -->
    <div class="detail">
        <c:if test="${empty cart.items}">
            <img src="https://rtworkspace.com/wp-content/plugins/rtworkspace-ecommerce-wp-plugin/assets/img/empty-cart.png"
                 style="width: 100%;height: 50%"/>
        </c:if>
        <div class="table-responsive-sm">
            <c:if test="${not empty cart}">
                <c:if test="${not empty cart.items}">
                    <table class="table">
                        <thead class="table-thead">
                        <tr>
                            <th class="text-center" scope="col">No</th>
                            <th class="text-center" scope="col">Name</th>
                            <th class="text-center" scope="col">Image</th>
                            <th class="text-center" scope="col">Price</th>
                            <th class="text-center" scope="col">Quantity</th>
                            <th class="text-center" scope="col">Total</th>

                            <th class="text-end" style="display: flex; justify-content: center;" scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="count" value="0"></c:set>
                        <c:forEach var="item" items="${cart.items}" varStatus="counter">
                            <tr>
                                <td class="text-center">${counter.count}</td>
                                <td class="text-center">${cart.products[item.key].name}</td>
                                <td class="text-center">
                                    <img alt="..."
                                         src="${cart.products[item.key].img}"
                                         class="rounded-circle"
                                         style="width: 40px; height: 40px;"
                                    />
                                </td>
                                <td class="text-center">$${cart.products[item.key].price}</td>

                                <td class="text-center">
                                    <div class="quantity">
                                        <c:url var="minus" value="minusQuantityCartAction">
                                            <c:param name="sku" value="${item.key}"/>

                                        </c:url>
                                        <c:url var="plus" value="plusQuantityCartAction">
                                            <c:param name="sku" value="${item.key}"/>

                                        </c:url>
                                        <a href="${minus}" class="minus-btn">-</a>
                                        <input class="quantity-input" type="number" value="${item.value}" readonly/>
                                        <a href="${plus}" class="plus-btn">+</a>

                                    </div>

                                </td>
                                <td class="text-center">$${cart.products[item.key].price * item.value}</td>
                                <td class="text-center" style="display: flex; justify-content: center;">
                                    <c:url var="remove" value="removeItemAction">
                                        <c:param name="sku" value="${item.key}"/>

                                    </c:url>
                                    <a type="button" href="${remove}" class="shop-btn_modify">
                                        <i class="fa fa-trash-alt"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                    <div class="detail-bottom">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="cart-information">
                                    <p>Full name</p>
                                    <input type="text" name="" value="${account.fullname}" readonly="">
                                </div>
                                <div class="cart-information">
                                    <p>Email</p>
                                    <input type="text" value="${account.email}" readonly="">
                                </div>
                                <div class="cart-information">
                                    <p>Phone</p>
                                    <input type="text" value=" ${account.phonenum}" readonly="">
                                </div>
                                <div class="cart-information">
                                    <p>Address</p>
                                    <input type="text" value="${account.address}" readonly="">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="cart-money">

                                    <div class="money">
                                        <p>Total:</p>
                                        <p>${cart.getTotalPrice()}</p>
                                    </div>
                                </div>

                            </div>

                        </div>
                        <a href="${checkout}" class="checkout-btn">Check out</a>

                    </div>
                </c:if>

            </c:if>


        </div>


        <!-- <div class="card-footer border-0 py-5">
                <span class="text-muted text-sm"
                  >Showing 10 items out of 250 results found</span
                >
              </div> -->
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/shop.js"></script>
<script src="js/alert.js"></script>
</body>

</html>