<%-- 
    Document   : manageuser
    Created on : Mar 9, 2023, 8:33:05 PM
    Author     : PC_HONGQUAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
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
                        <div class="detail-title" style="display: flex; justify-content: flex-end">
                            <div style="display: flex; ">
                                <c:url var="loadcreateaccount" value="loadCreateAccountAction">
                                </c:url>
                                <div id="shoptitlebtn" class="shoptitle-btn">
                                    <a
                                        href="${loadcreateaccount}"
                                        class="admin-btn"

                                        >
                                        Create user</a
                                    >
                                </div>
                                <div class="search">
                                    <form action="searchAccountAction" method="POST">
                                        <input class="search-input" type="text" placeholder="Search by name" name="txtSearch" value="${txtSearch}"/>
                                        <button type="submit" class="search-btn">Search</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <p class="text-danger" style="font-size: 1.4rem">${error.getAddressIsEmptyError()}</p>
                        <p class="text-danger" style="font-size: 1.4rem">${error.getPasswordLengthError()}</p>
                        <p class="text-danger" style="font-size: 1.4rem">${error.getPhonenumIsEmptyError()}</p>
                        <p class="text-danger" style="font-size: 1.4rem">${error.getPhonenumIsNotNumberError()}</p>
                        <div class="table-responsive">
                            <table class="table">
                                <thead class="table-thead">
                                    <tr>
                                        <th class="text-center" scope="col">Email</th>
                                        <th class="text-center" scope="col">Full Name</th>
                                        <th class="text-center" scope="col">Password</th>

                                        <th class="text-center" scope="col">Address</th>
                                        <th class="text-center" scope="col">Phone number</th>

                                        <th class="text-center" scope="col">Role</th>
                                        <th class="text-center" scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dto" items="${accounts}">
                                    <form action="updateAccountByAdminAction" method="POST">
                                        <tr>
                                            <td class="text-center" >${dto.email}
                                                <input type="hidden" name="email" value="${dto.email}"/>
                                            </td>
                                            <td class="text-center" >${dto.fullname}</td>
                                            <td class="text-center" >
                                                <input class="input-edit-user" type="text" name="password" value="${dto.password}" />
                                            </td>


                                            <td class="text-center" >                            
                                                <input class="input-edit-user" type="text" name="address" value="${dto.address}" />
                                            </td>
                                            <td class="text-center" >                                       
                                                <input class="input-edit-user" type="text" name="phonenum" value="${dto.phonenum}" />
                                            </td>


                                            <td class="text-center" >
                                                <select class="input-edit" name="roleId">
                                                    <c:forEach var="rItem" items="${roles}">
                                                        <option value="${rItem.id}"
                                                                <c:if test="${dto.role.id == rItem.id}">
                                                                    selected="selected"
                                                                </c:if>

                                                                >${rItem.role}</option>

                                                    </c:forEach>
                                                </select>

                                            </td>

                                            <td class="text-end">
                                                <button type="submit" class="btn btn-sm btn-neutral">
                                                    <i class="fa fa-edit shop-btn_modify"></i
                                                    ></button>
                                                    <c:url var="deleteaccount" value="deleteAccountByAdminAction">
                                                        <c:param name="email" value="${dto.email}"></c:param>
                                                    </c:url>
                                                <a
                                                    href="${deleteaccount}"
                                                    class="btn btn-sm btn-square btn-neutral text-danger-hover"

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
                                <c:forEach begin="1" end="${totalUser}" var="i">
                                    <c:url var="paging" value="manageUserAction">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/shop.js"></script>
    </body>
</html>
