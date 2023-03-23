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
                                            >Product (${productCount})</a
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
                                    <form action="searchProductByAdminAction">
                                        <input class="search-input" type="text" placeholder="Search by name" name="txtSearch" value="${txtSearch}"/>
                                        <button type="submit" class="search-btn">Search</button>
                                    </form>

                                </div>
                            </div>
                        </div>



                        <div class="table-responsive">
                            <table class="table">
                                <thead class="table-thead">
                                    <tr>
                                        <th class="text-center" scope="col">SKU</th>
                                        <th class="text-center" scope="col">Name</th>
                                        <th class="text-center" scope="col">Image</th>
                                        <th class="text-center" scope="col">Price</th>
                                        <th class="text-center" scope="col">Quantity</th>
                                        <th class="text-center" scope="col">Status</th>

                                        <th class="text-center" scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td></td>                            
                                        <td></td>
                                        <td></td>
                                        <td class="text-center">
                                            <p class="text-danger" style="font-size: 1.4rem">${e.getPriceIsEmptyError()}</p>
                                            <p class="text-danger" style="font-size: 1.4rem">${e.getPriceIsNumberError()}</p>
                                        </td>
                                        <td class="text-center">  
                                            <p class="text-danger" style="font-size: 1.4rem">${e.getQuantityIsEmptyError()}</p>
                                            <p class="text-danger" style="font-size: 1.4rem">${e.getQuantityIsNumberError()}</p>
                                        </td>
                                        <td></td>
                                        <td></td>


                                    </tr>
                                    <c:forEach var="dto" items="${products}">
                                    <form action="updateProductAction" method="POST">
                                        <tr>
                                            <td class="text-center">${dto.sku}
                                                <input class="input-edit" type="hidden" name="sku" value="${dto.sku}"  />

                                            </td>
                                            <td class="text-center">${dto.name}</td>
                                            <td class="text-center">
                                                <img
                                                    alt="..."
                                                    src="${dto.img}"                      
                                                    class="rounded-circle img-table"
                                                    />
                                            </td>
                                            <td class="text-center">

                                                <input class="input-edit" type="number" name="price" value="${dto.price}"  />
                                            </td>

                                            <td class="text-center">

                                                <input class="input-edit" type="number" name="quantity" value="${dto.quantity}"  />

                                            </td>
                                            <td class="text-center">

                                                <select name="sId">
                                                    <c:forEach var="item" items="${statuses}">
                                                        <option 
                                                            <c:if test="${item.id == dto.status.id}">
                                                                selected = "selected"
                                                            </c:if>
                                                            value="${item.id}"
                                                            >
                                                            ${item.status}
                                                        </option>

                                                    </c:forEach>
                                                </select>

                                            </td>

                                            <td class="text-center">
                                                <input type="hidden" name="btAction" value="Update Product"/>
                                                <button
                                                    type="submit"
                                                    class="btn btn-sm btn-neutral"
                                                    >
                                                    <i class="fa fa-edit shop-btn_modify"></i
                                                    ></button>
                                                <a
                                                    type="button"
                                                    class="btn btn-sm btn-square btn-neutral"
                                                    href="deleteProductAction?sku=${dto.sku}"
                                                    >
                                                    <i class="fa fa-trash-alt shop-btn_modify"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </form>


                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- <div class="card-footer border-0 py-5">
                                <span class="text-muted text-sm"
                                  >Showing 10 items out of 250 results found</span
                                >
                              </div> -->

                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-end">
                                <c:forEach begin="1" end="${totalProduct}" var="i">
                                    <c:url var="paging" value="manageProductAction">
                                        <c:param name="index" value="${i}"></c:param>
                                        <c:param name="filter" value="Product"></c:param>

                                    </c:url>
                                    <li class="page-item"><a class="page-link" href="${paging}">${i}</a></li>

                                </c:forEach>


                            </ul>
                        </nav>
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
