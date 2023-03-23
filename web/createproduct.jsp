<%-- 
    Document   : createproduct
    Created on : Mar 11, 2023, 3:51:11 PM
    Author     : PC_HONGQUAN
--%>
<%-- 
    Document   : manageproduct
    Created on : Mar 9, 2023, 7:48:46 PM
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
        <c:set var="e" value="${INSERT_ERROR}"></c:set>
        <c:url var="logout" value="logoutAction">
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
                        <form action="insertProductAction" method="POST" class="mon-form" >
                            <h3 class="shopname">CREATE PRODUCT</h3>
                            <p>Enter SKU</p>
                            <p class="text-danger">${e.getSkuIsExistError()}</p>
                            <p class="text-danger">${e.getSkuIsEmptyError()}</p>

                            <input
                                name="sku"
                                class="input-form"
                                type="text"
                                aria-required="true"
                                />
                            <p>Enter product name</p>
                            <p class="text-danger">${e.getProductNameIsEmptyError()}</p>

                            <input
                                name="pName"
                                class="input-form"
                                type="text"
                                aria-required="true"
                                />
                            <p>Enter image</p>
                            <p class="text-danger">${e.getImageIsEmptyError()}</p>

                            <input
                                name="image"
                                class="input-form"
                                type="text"
                                aria-required="true"
                                />
                            <p>Enter price</p>
                            <p class="text-danger">${e.getPriceIsEmptyError()}</p>
                            <p class="text-danger">${e.getPriceIsNumberError()}</p>



                            <input
                                name="price"
                                class="input-form"
                                type="text"
                                aria-required="true"
                                />

                            <p>Enter quantity</p>
                            <p class="text-danger">${e.getQuantityIsEmptyError()}</p>
                            <p class="text-danger">${e.getQuantityIsNumberError()}</p>


                            <input
                                name="quantity"
                                class="input-form"
                                type="number"
                                aria-required="true"
                                />
                            <h5>Description</h5>
                            <p class="text-danger">${e.getDescriptionIsEmptyError()}</p>

                            <textarea
                                class="input-form"
                                name="description"
                                id=""
                                cols="90"
                                rows="10"
                                ></textarea>


                            <h5>Category</h5>
                            <select class="input-form" name="cId">
                                <c:forEach var="cItem" items="${categories}">
                                    <option value="${cItem.id}">${cItem.category}</option>

                                </c:forEach>
                            </select>
                            <h5>Product Status</h5>
                            <select class="input-form" name="sId">
                                <c:forEach var="sItem" items="${statuses}">
                                    <option value="${sItem.id}">${sItem.status}</option>

                                </c:forEach>
                            </select>

                            <input
                                class="btn-submit edit-btn"
                                type="submit"
                                value="Insert Product"
                                name="btAction"
                                />
                        </form>
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
