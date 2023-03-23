<%-- 
    Document   : productdetail
    Created on : Mar 7, 2023, 1:45:18 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Product detail</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/productdetail.css" />
        <link rel="stylesheet" href="css/shop.css" />
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
                <div class="productdetail">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="product-img">
                                <img
                                    src="${product.img}"
                                alt=""
                                />
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="productdetail-item">
                            <h5 class="productdetail-title">
                                ${product.name}
                            </h5>
                            <div class="productdetail-category">
                                <h5 class="productdetail-category__cate">Category</h5>
                                <h5 class="productdetail-category__cateP"> ${product.category.category} </h5>
                            </div>
                            <div class="productdetail-category">
                                <h5 class="productdetail-category__cate">Status</h5>
                                <h5 class="productdetail-category__cateP"> ${product.status.status} </h5>
                            </div>
                            <div class="productdetail-category">
                                <h5 class="productdetail-category__cate">Price</h5>

                                <h5 class="productdetail-category__cateP">$${product.price}</h5>
                            </div>


                            <c:if test="${product.status.id != 2}">
                                <div class="productdetail-available">
                                    <h5 class="productdetail-available-count">${product.quantity}</h5>
                                    <h5 class="productdetail-available-title">products left</h5>
                                </div>
                            </c:if>

                            <h5 class="productdetail-category__cate">Description</h5>
                            <p style="font-size: 1.4rem;">${product.description}</p>
                            <c:if test="${product.status.id != 2}">
                                <form action="addToCartAction">
                                    <input type="hidden" name="sku" value="${product.sku}"/>
                                    <div class="quantity">
                                        <!--<a href="#" class="minus-btn">-</a>-->
                                        <input class="quantity-input" type="number" value="1" name="quantity"/>
                                        <div class="detail-btn">
                                            <button

                                                class="productdetail-btn"

                                                type="submit"
                                                />Add to cart</button>
                                        </div>
                                        <!--<a href="#" class="plus-btn">+</a>-->
                                    </div>
                                    <!--<input type="hidden" name="btAction" value="Add To cart P Details"/>-->
                                    <input type="hidden" name="btAction" value="Add To Cart"/>


                                </form>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>

            <div class="relateproduct">
                <h5 class="relateproduct__title">New Products</h5>
                <div class="row">
                    <c:forEach var="pItem" items="${products}">
                        <div class="col-md-3">
                            <div class="product-item">
                                <a href="DispatchServlet?btAction=Show Product Detail&sku=${pItem.sku}" class="product-img">
                                    <img
                                        src="${pItem.img}"
                                        alt="${pItem.name}"
                                        />
                                </a>
                                <a href="DispatchServlet?btAction=Show Product Detail&sku=${pItem.sku}" class="product-title">
                                    <h4>${pItem.name}</h4>
                                </a>
                                <div class="product-price">
                                    <p class="product-price__new">$${pItem.price}</p>
                                    <p class="product-price__old">${pItem.price*130/100}$</p>
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
