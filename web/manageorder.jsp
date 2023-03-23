<%-- 
    Document   : manageorder
    Created on : Mar 9, 2023, 9:02:33 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Manage order</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
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
        <!-- Bootstrap CSS -->
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

        <c:url var="manageorders" value="manageOrdersAction">
            <c:param name="status" value="1"></c:param>
        </c:url> 
        <c:url var="manageordersinprogress" value="manageOrdersAction">
            <c:param name="status" value="2"></c:param>

        </c:url>
        <c:url var="manageorderscompleted" value="manageOrdersAction">
            <c:param name="status" value="3"></c:param>

        </c:url>

        <div class="container-fluid">
            <div class="row">
                <jsp:include page="sidebar.jsp"></jsp:include>
                    <div class="col-md-10 right">
                        <div class="shoptitle">
                            <h3 class="shoptitleh3">Order</h3>
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
                                            href="${manageorders}"
                                            >Products Pending (${orderPending})</a
                                        >
                                    </li>
                                    <li>
                                        <a
                                            class="navbar-nav__link navbar-nav__link-first"
                                            href="${manageordersinprogress}"
                                            >Products Is Progress (${orderInprogress})</a
                                        >
                                    </li>
                                    <li>
                                        <a class="navbar-nav__link"
                                           href="${manageorderscompleted}"
                                           >Products Completed (${orderCompleted})</a
                                        >
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="detail-title">
                            <div class="search">
                                <form action="searchOrderAction">
                                    <input class="search-input" type="text" placeholder="Search by name" name="txtSearch" value="${txtSearch}"/>
                                    <button type="submit" class="search-btn">Search</button>
                                </form>

                            </div>
                        </div>
                        <div class="table-responsive-sm table-responsive-md">
                            <table class="table table-hover">
                                <thead class="table-thead">
                                    <tr>
                                        <th class="text-center" scope="col">ID</th>
                                        <th class="text-center" scope="col">Email</th>
                                        <th class="text-center" scope="col">Full Name</th>

                                        <th class="text-center"  scope="col">Phone</th>
                                        <th class="text-center" scope="col">Address</th>
                                        <th class="text-center" scope="col">Order day</th>
                                        <th class="text-center" scope="col">Status</th>

                                        <th class="text-center" scope="col">Total</th>
                                        <th class="text-center" scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dto" items="${orders}">
                                        <tr>
                                            <td class="text-center">${dto.id}</td>
                                            <td class="text-center">${dto.account.email}</td>
                                            <td class="text-center">${dto.account.fullname}</td>
                                            <td class="text-center">${dto.account.phonenum}</td>
                                            <td class="text-center">${dto.account.address}</td>

                                            <td class="text-center">
                                                ${dto.orderDate}
                                            </td>
                                            <td class="text-center">
                                                ${dto.orderStatus.status} 
                                            </td>
                                            <td class="text-center">
                                                ${dto.total}
                                            </td>

                                            <td class="text-center">
                                                <form action="viewOrderDetailsAction">
                                                    <input type="hidden" name="orderid" value="${dto.id}" />
                                                    <input type="hidden" name="total" value="${dto.total}" />
                                                    <input type="hidden" name="status" value="${dto.orderStatus.status}" />
                                                    <input type="hidden" name="statusId" value="${dto.orderStatus.id}" />

                                                    <input type="submit" value="View" class="action-btn"/>
                                                </form>
                                              
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
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-end">
                                <c:forEach begin="1" end="${totalPage1}" var="i">
                                    <c:url var="paging" value="manageOrdersAction">
                                        <c:param name="index" value="${i}"></c:param>

                                    </c:url>
                                    <li class="page-item"><a class="page-link" href="${paging}">${i}</a></li>


                                </c:forEach>



                            </ul>
                        </nav>

                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-end">
                                <c:forEach begin="1" end="${totalPage2}" var="i">
                                    <c:url var="paging" value="manageOrdersAction">
                                        <c:param name="index" value="${i}"></c:param>

                                    </c:url>
                                    <li class="page-item"><a class="page-link" href="${paging}">${i}</a></li>


                                </c:forEach>



                            </ul>
                        </nav>

                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-end">
                                <c:forEach begin="1" end="${totalPage3}" var="i">
                                    <c:url var="paging" value="manageOrdersAction">
                                        <c:param name="index" value="${i}"></c:param>

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
        <script src="js/shop.js"></script>
    </body>
</html>
