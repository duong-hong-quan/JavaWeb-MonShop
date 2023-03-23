<%-- 
    Document   : fewstolkleft
    Created on : Mar 9, 2023, 8:19:41 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Manage product</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- Bootstrap CSS -->
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
        <div class="container-fluid">
            <div class="row">
                <jsp:include page="sidebar.jsp"></jsp:include>
                    <div class="col-md-10 right">
                        <div class="shoptitle">
                            <h3 class="shoptitleh3">Product</h3>
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
                        <div class="nav-link">
                            <nav class="navbar">
                                <ul class="nav navbar-nav">
                                    <li>
                                        <a
                                            class="navbar-nav__link navbar-nav__link-first"
                                            href="${manageproduct}"
                                            >Product</a
                                        >
                                    </li>
                                    <li>
                                        <a class="navbar-nav__link" href="${stolkproducts}">Few stocks left (${lowstolkproducts})</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="detail-title">
                            <div style="display: flex; justify-content: flex-end">
                                <div id="shoptitlebtn" class="shoptitle-btn">
                                    <c:url var="createproduct" value="loadCreateProductAction">
                                    </c:url>
                                    <a
                                        href="createCategory"
                                        class="admin-btn"

                                        >
                                        Create category
                                    </a>

                                    <a
                                        href="${createproduct}"
                                        class="admin-btn"

                                        >
                                        Create product</a
                                    >
                                </div>
                                <div class="search">
                                    <input class="search-input" type="text" />
                                    <button type="submit" class="search-btn">Search</button>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive-sm table-responsive-md">
                            <table class="table">
                                <thead class="table-thead">
                                    <tr>
                                        <th class="text-center" scope="col">SKU</th>
                                        <th class="text-center" scope="col">Name</th>
                                        <th class="text-center" scope="col">Image</th>
                                        <th class="text-center" scope="col">Price</th>
                                        <th class="text-center" scope="col" style="color: red">
                                            Quantity
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dto" items="${products}">
                                        <tr>
                                            <td class="text-center">${dto.sku}</td>
                                            <td class="text-center">${dto.name}</td>
                                            <td class="text-center">
                                                <img
                                                    alt="..."
                                                    src="${dto.img}"
                                                    class="rounded-circle img-table"
                                                    />
                                            </td>
                                            <td class="text-center">$${dto.price}</td>

                                            <td class="text-center">
                                                <p style="color: red; font-weight: bold">${dto.quantity}</p>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                          
                        </div>
                        <!-- <div class="card-footer border-0 py-5">
                                <span class="text-muted text-sm"
                                  >Showing 10 items out of 250 results found</span
                                >
                              </div> -->

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
