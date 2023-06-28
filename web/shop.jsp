<%-- 
    Document   : shop.jsp
    Created on : Mar 6, 2023, 7:43:52 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shop</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/base.css"/>
    <link rel="stylesheet" href="css/responsive.css"/>
    <link rel="stylesheet" href="css/shop.css"/>
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

<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="sidebar">
                <h3 class="list-siderbar-item">Categories</h3>

                <ul class="siderbar-list">
                    <c:forEach var="cItem" items="${categories}">
                        <li>
                            <c:url var="filtercategory" value="filterProductAction">
                                <c:param name="cid" value="${cItem.id}"></c:param>
                                <c:param name="filter" value="Filter By Category"></c:param>

                            </c:url>
                            <a class="sidebar-item" href="${filtercategory}">${cItem.category}</a>
                        </li>
                    </c:forEach>


                </ul>


            </div>
        </div>

        <div class="col-md-9">
            <div style="margin: 2rem" class="justify-content-end">
                <div class="dropdown">
                    <button class="dropdown-toggle" style="font-size: 1.6rem">
                        <i style="border: none" class="fa fa-filter"></i>

                        Filter
                    </button>
                    <c:url var="lowtohigh" value="filterProductAction">

                        <c:param name="filter" value="Low To High"></c:param>
                    </c:url>
                    <c:url var="hightolow" value="filterProductAction">
                        <c:param name="filter" value="High To low"></c:param>
                    </c:url>
                    <c:url var="newproducts" value="filterProductAction">

                        <c:param name="filter" value="New Products"></c:param>
                    </c:url>
                    <div style="min-width: 175px" class="dropdown-content">
                        <a href="${lowtohigh}">Low to high</a>
                        <a href="${hightolow}">Hight to low</a>
                        <a href="${newproducts}">New products</a>
                    </div>
                </div>
            </div>
            <div class="product-list">
                <div class="row">
                    <c:forEach var="pItem" items="${products}">
                        <div class="col-md-4">
                            <div class="product-item">
                                <c:url var="showproduct" value="showProductAction">
                                    <c:param name="sku" value="${pItem.sku}"></c:param>
                                </c:url>
                                <a href="${showproduct}" class="product-img">
                                    <img
                                            src="${pItem.img}"
                                            alt="${pItem.name}"
                                    />
                                </a>
                                <a href="" class="product-title">
                                    <h4>${pItem.name}</h4>
                                </a>
                                <div class="product-price">
                                    <p class="product-price__new">$${pItem.price}</p>
                                    <p class="product-price__old">$${pItem.price*130/100}</p>
                                </div>
                                <c:url var="addtocart" value="addToCartAction">
                                    <c:param name="sku" value="${pItem.sku}"></c:param>
                                </c:url>
                                <a href="${addtocart}" class="product-btn">Add to cart</a>
                                <div class="saleoff_tag"><p>-30%</p></div>
                            </div>
                        </div>

                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
    <nav aria-label="Page navigation example">

        <div class="justify-content-end">
            <ul class="pagination">
                <c:forEach begin="1" end="${countPage}" var="i">
                    <c:url var="paging" value="viewShop">
                        <c:param name="index" value="${i}"></c:param>

                    </c:url>
                    <li class="page-item"><a class="page-link" href="${paging}">${i}</a></li>

                </c:forEach>


            </ul>
        </div>
    </nav>

    <nav aria-label="Page navigation example">

        <div class="justify-content-end">
            <ul class="pagination">
                <c:forEach begin="1" end="${countPage2}" var="i">
                    <c:url var="paging" value="filterProductAction">
                        <c:param name="filter" value="Filter By Category"></c:param>
                        <c:param name="cid" value="${cid}"></c:param>
                        <c:param name="index" value="${i}"></c:param>
                    </c:url>
                    <li class="page-item"><a class="page-link" href="${paging}">${i}</a></li>

                </c:forEach>


            </ul>
        </div>
    </nav>
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
