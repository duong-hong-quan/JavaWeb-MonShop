<%-- 
    Document   : account
    Created on : Mar 7, 2023, 2:44:22 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Account</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <link rel="stylesheet" href="css/account.css" />
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/responsive.css">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
    </head>
    <body>
        <c:set var="error" value="${INSERTERR}"></c:set>

        <jsp:include page="header.jsp"></jsp:include>
        <c:url var="shop" value="viewShop">

        </c:url>

        <c:url var="orderview" value="orderViewAction">
        </c:url>
        <div class="container" >
            <div class="row">
                <div class="col-md-3">
                    <div class="sidebar">
                        <h3 class="list-siderbar-item">Information</h3>

                        <ul class="siderbar-list">
                            <li class="">
                                <a class="sidebar-item" href="accountPage">Account</a>
                            </li>
                            <li class="">
                                <a class="sidebar-item" href="orderViewAction">Order</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-9">
                    <form class="account-form" action="updateInformationUserAction" method="POST">
                        <h3 style="text-align: center; margin-bottom: 20px">
                            Update information
                        </h3>

                        <div class="avatar">
                            <img id="preview" src="${sessionScope.account.image}" />
                        </div>
                        <p>Enter URL avatar</p>

                        <input
                            type="text"
                            class="input-add"
                            id="img-url"
                            oninput="previewImage()"
                            value="${sessionScope.account.image}"
                            name="img"
                            />


                        <p>Enter Email</p>
                        <input
                            name="email"
                            class="input-add"
                            type="text"
                            readonly="" 
                            aria-required="true"
                            value="${sessionScope.account.email}"
                            />
                        <p>Enter Password</p>
                        <p class="text-danger">${error.getPasswordLengthError()}</p>
                        <p class="text-danger">${error.getPasswordNotMatch()}</p>
                        <input
                            name="password"
                            class="input-add"
                            type="text"
                            aria-required="true"
                            value="${sessionScope.account.password}"
                            />
                        <p>Enter full name</p>
                        <p class="text-danger">${error.getFullnameIsEmptyError()}</p>

                        <input
                            name="fullname"
                            class="input-add"
                            type="text"
                            aria-required="true"
                            value="${sessionScope.account.fullname}"
                            />
                        <p>Enter address</p>
                        <p class="text-danger">${error.getAddressIsEmptyError()}</p>

                        <input
                            name="address"
                            class="input-add"
                            type="text"
                            aria-required="true"
                            value="${sessionScope.account.address}"
                            />

                        <p>Enter phone number</p>
                        <p class="text-danger">${error.getPhonenumIsEmptyError()}</p>
                        <p class="text-danger">${error.getPhonenumIsNotNumberError()}</p>
                        <input
                            name="phonenum"
                            class="input-add"
                            type="number"
                            aria-required="true"
                            value="${sessionScope.account.phonenum}"

                            />
                        <input type="hidden" name="role" value="${sessionScope.account.role.id}"/>

                        <input type="submit" class="btn-submit shop-btn" value="Update information" name="btAction"/>
                    </form>
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
