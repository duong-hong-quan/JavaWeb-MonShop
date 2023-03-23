<%-- 
    Document   : login
    Created on : Mar 6, 2023, 10:05:41 PM
    Author     : PC_HONGQUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
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
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <div class="container-fluid login-background">
            <div class="row">
                <div class="col-md-12">
                    <form class="mon-form" action="loginAction" method="POST">
                        <h4 class="title-shop"><a href="viewShop">MON SHOP</a></h4>

                        <img
                            src="https://i.pinimg.com/736x/89/90/48/899048ab0cc455154006fdb9676964b3.jpg"
                            class="rounded-circle mon-img"
                            />

                        <h4 class="title-form">LOGIN</h4>
                        <p class="text-danger">${error}</p>
                        <p class="text-danger">${msgCart}</p>

                        <input
                            name="email"
                            class="input-form"
                            type="text"
                            placeholder="Enter username"
                            required=""
                            aria-required="true"
                            />

                        <input
                            type="password"
                            class="input-form"
                            name="password"
                            placeholder="********"
                            required="required"
                            />
                        <input type="hidden" name="redirectToCart" value="${redirectToCart}"/>

                        <input class="btn-submit " type="submit" value="Login" name="btAction"/>

                        <div class="form-group">
                            <span>I don't have account !</span>
                            <a class="btn_uy" href="signupPage"><span>Sign up!</span></a>
                        </div>
                    </form>
                </div>
            </div>

        </div>
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
