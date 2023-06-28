<%-- 
    Document   : createaccount
    Created on : Mar 11, 2023, 3:32:55 PM
    Author     : PC_HONGQUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%-- 
    Document   : manageuser
    Created on : Mar 9, 2023, 8:33:05 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create Account</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/admin.css"/>
    <link rel="stylesheet" href="css/responsive.css"/>
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
<c:set var="error" value="${INSERTERR}"></c:set>

<c:url var="logout" value="logoutAction">
</c:url>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="sidebar.jsp"></jsp:include>
        <div class="col-md-10 right">
            <div class="shoptitle">
                <h3 class="shoptitleh3">User</h3>
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
            <div class="detail">
                <form class="mon-form" action="insertAccountByAdminAction" method="POST">
                    <h3 class="shopname">CREATE ACCOUNT</h3>
                    <div class="avatar">
                        <img id="preview"/>
                    </div>
                    <p>Enter URL avatar</p>

                    <input
                            type="text"
                            class="input-form"
                            id="img-url"
                            oninput="previewImage()"
                            placeholder="URL Avatar"
                            name="img"
                    />

                    <p>Enter Email</p>
                    <p class="text-danger">${error.getAccountIsExisted()}</p>

                    <p class="text-danger">${error.getEmailFormatError()}</p>
                    <p class="text-danger">${error.getEmailIsEmptyError()}</p>

                    <input
                            name="email"
                            class="input-form"
                            type="text"
                            aria-required="true"
                            placeholder="Email"
                    />


                    <p>Enter Password</p>
                    <p class="text-danger">${error.getPasswordLengthError()}</p>
                    <p class="text-danger">${error.getPasswordNotMatch()}</p>
                    <input
                            name="password"
                            class="input-form"
                            type="password"
                            aria-required="true"
                            placeholder="Password"

                    />


                    <p>Enter full name</p>
                    <p class="text-danger">${error.getFullnameIsEmptyError()}</p>

                    <input
                            name="fullname"
                            class="input-form"
                            type="text"
                            aria-required="true"
                            placeholder="Full Name"

                    />

                    <p>Enter address</p>
                    <p class="text-danger">${error.getAddressIsEmptyError()}</p>

                    <input
                            name="address"
                            class="input-form"
                            type="text"
                            aria-required="true"
                            placeholder="Address"

                    />


                    <p>Enter Phone Number</p>
                    <p class="text-danger">${error.getPhonenumIsEmptyError()}</p>
                    <p class="text-danger">${error.getPhonenumIsNotNumberError()}</p>
                    <input
                            name="phonenum"
                            class="input-form"
                            type="number"
                            aria-required="true"
                            placeholder="Phone number"

                    />


                    <h5>Role</h5>
                    <select class="input-form" name="roleId">
                        <c:forEach var="rItem" items="${roles}">
                            <option value="${rItem.id}">${rItem.role}</option>

                        </c:forEach>
                    </select>
                    <input
                            class="btn-submit edit-btn"
                            type="submit"
                            value="Create Account"
                            name="btAction"
                    />
                </form>


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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/shop.js"></script>
</body>
</html>
