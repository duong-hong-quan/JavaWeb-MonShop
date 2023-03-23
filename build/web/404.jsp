<%-- 
    Document   : 404
    Created on : Mar 10, 2023, 8:25:02 AM
    Author     : PC_HONGQUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>404 NOT FOUND</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/responsive.css" />
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
        <style>
            * {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
            }

            body {
                padding: 0;
                margin: 0;
            }

            #notfound {
                position: relative;
                height: 100vh;
            }

            #notfound .notfound {
                position: absolute;
                left: 50%;
                top: 50%;
                -webkit-transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }

            .notfound {
                max-width: 920px;
                width: 100%;
                line-height: 1.4;
                text-align: center;
                padding-left: 15px;
                padding-right: 15px;
            }

            .notfound .notfound-404 {
                position: absolute;
                height: 100px;
                top: 0;
                left: 50%;
                -webkit-transform: translateX(-50%);
                -ms-transform: translateX(-50%);
                transform: translateX(-50%);
                z-index: -1;
            }

            .notfound .notfound-404 h1 {
                font-family: "Maven Pro", sans-serif;
                color: #ececec;
                font-weight: 900;
                font-size: 276px;
                margin: 0px;
                position: absolute;
                left: 50%;
                top: 50%;
                -webkit-transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }

            .notfound h2 {
                font-family: "Maven Pro", sans-serif;
                font-size: 46px;
                color: #000;
                font-weight: 900;
                text-transform: uppercase;
                margin: 0px;
            }

            .notfound p {
                font-family: "Maven Pro", sans-serif;
                font-size: 16px;
                color: #000;
                font-weight: 400;
                text-transform: uppercase;
                margin-top: 15px;
            }

            .notfound a {
                font-family: "Maven Pro", sans-serif;
                font-size: 14px;
                text-decoration: none;
                text-transform: uppercase;
                background: #000;
                display: inline-block;
                padding: 16px 38px;
                border: 2px solid transparent;
                border-radius: 40px;
                color: #fff;
                font-weight: 400;
                -webkit-transition: 0.2s all;
                transition: 0.2s all;
            }

            .notfound a:hover {
                background-color: #fff;
                border-color: #000;
                color: #000;
            }

            @media only screen and (max-width: 480px) {
                .notfound .notfound-404 h1 {
                    font-size: 162px;
                }
                .notfound h2 {
                    font-size: 26px;
                }
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container-fluid">
                <div id="notfound">
                    <div class="notfound">
                        <div class="notfound-404">
                            <h1>404</h1>
                        </div>
                        <h2>We are sorry, Page not found!</h2>
                        <p>
                            The page you are looking for might have been removed had its name
                            changed or is temporarily unavailable.
                        </p>
                        <a href="viewShop">Back To Homepage</a>
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
