<%-- 
    Document   : signup
    Created on : Mar 11, 2023, 8:10:49 AM
    Author     : LAPTOP_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Sign up</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/login.css" />
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
            <div class="container-fluid login-background" style="height: auto">
                <div class="row">
                    <div class="col-md-12">
                        <form class="mon-form" action="DispatchServlet" method="POST">
                            <h4 class="title-shop"><a href="shop.html">MON SHOP</a></h4>

                            <img
                                src="https://i.pinimg.com/736x/89/90/48/899048ab0cc455154006fdb9676964b3.jpg"
                                class="rounded-circle mon-img"
                                />

                            <h4 class="title-form">SIGN UP</h4>
                            <ul class="note-signup">
                                <li>
                                    Email field must be in a valid format and cannot be left empty.
                                </li>
                                <li>
                                    Full name field cannot be left
                                    empty.
                                </li>
                                <li>Address field cannot be left empty.</li>
                                <li>
                                    Phone number field must contain only numbers and cannot be left
                                    empty.
                                </li>
                                <li>
                                    Password field must be at least 8 characters and at most 20
                                    characters.
                                </li>
                                <li>Repeat password field must match the password field.</li>
                            </ul>

                        <p class="text-danger">${error.getAccountIsExisted()}</p>

                        <p class="text-danger">${error.getEmailFormatError()}</p>
                        <p class="text-danger">${error.getEmailIsEmptyError()}</p>

                        <input
                            name="email"
                            class="input-form"
                            type="text"
                            placeholder="Enter email"
                            aria-required="true"
                            />
                        <p class="text-danger">${error.getFullnameIsEmptyError()}</p>

                        <input
                            name="fullname"
                            class="input-form"
                            type="text"
                            placeholder="Enter full name"
                            aria-required="true"
                            />
                        <p class="text-danger">${error.getAddressIsEmptyError()}</p>

                        <input
                            type="text"
                            class="input-form"
                            name="address"
                            placeholder="Address"
                            />
                        <p class="text-danger">${error.getPhonenumIsEmptyError()}</p>
                        <p class="text-danger">${error.getPhonenumIsNotNumberError()}</p>


                        <input
                            type="text"
                            class="input-form"
                            name="phonenum"
                            placeholder="Phone number"
                            />
                        <p class="text-danger">${error.getPasswordLengthError()}</p>
                        <p class="text-danger">${error.getPasswordNotMatch()}</p>


                        <input
                            type="password"
                            class="input-form"
                            name="password"
                            placeholder="Password"
                            />
                        <input
                            type="password"
                            class="input-form"
                            name="repassword"
                            placeholder="Repeat password"
                            />

                        <input
                            class="btn-submit"
                            type="submit"
                            value="Sign Up"
                            name="btAction"
                            />

                        <div class="form-group">
                            <span>I have account !</span>
                            <a class="btn_uy" href="login.jsp"><span>Log in!</span></a>
                        </div>
                    </form>
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
