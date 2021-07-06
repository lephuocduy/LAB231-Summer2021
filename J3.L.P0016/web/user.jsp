<%-- 
    Document   : user
    Created on : May 18, 2021, 12:35:46 AM
    Author     : Le Phuoc Duy
--%>

<%@page import="duylp.dtos.ListRequestDTO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPD</title>
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
            crossorigin="anonymous"
            />
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./css/user.css" />
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg">
                <div class="col-6 col-md-5 col-lg-5 col-xl-4">
                    <div class="header__left">
                        <a class="navbar-brand mr-0" href="#">
                            <img src="./img/logoLPD.jpg" alt="" />
                        </a>
                        <form action="MainController" method="POST" class="header__form align-self-center ml-5"> 
                            <input type="hidden" name="txtRoleID" value="${sessionScope.ROLEID}" />
                            <div class="input-group ml-2" style="height: 100%;">
                                <input
                                    type="text"
                                    name="txtSearch"
                                    value="${param.txtSearch}"
                                    class="form-control ude-HoverbgInputSearch"
                                    placeholder="Search for anything"
                                    aria-label="Recipient's username"
                                    aria-describedby="basic-addon2"
                                    />
                                <button type="submit"
                                        name="action"
                                        value="SearchProduct"
                                        class="ude-btnHoverbgSearch">
                                    <div class="input-group-append button">
                                        <span
                                            class="input-group-text ude-btnHoverSearch"
                                            id="basic-addon2"
                                            ><i class="fa fa-search"></i
                                            ></span>
                                    </div>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-6 col-md-7 col-lg-7 col-xl-8 px-0">
                    <div class="header__right">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item business">
                                <ul class="nav nav-pills" id="pills-tab" role="tablist">
                                    <li class="nav-item">
                                        <a
                                            class="nav-link p-3 ude-btnHoverHeader"
                                            id="pills-1-tab"
                                            data-toggle="pill"
                                            href="#pills-1"
                                            role="tab"
                                            aria-controls="pills-1"
                                            aria-selected="true"
                                            >
                                            <i class="fa fa-th"></i>
                                            Categories
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <Button
                                            class="nav-link p-3 ude-btnHoverHeader"
                                            id="pills-2-tab"
                                            data-toggle="pill"
                                            href="#pills-2"
                                            role="tab"
                                            aria-controls="pills-2"
                                            aria-selected="false"
                                            >
                                            Electronice
                                        </Button>
                                    </li>
                                    <li class="nav-item">
                                        <a
                                            class="nav-link p-3 ude-btnHoverHeader"
                                            id="pills-3-tab"
                                            data-toggle="pill"
                                            href="#pills-3"
                                            role="tab"
                                            aria-controls="pills-3"
                                            aria-selected="false"
                                            >
                                            Item
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a
                                            class="nav-link p-3 ude-btnHoverHeader"
                                            id="pills-4-tab"
                                            data-toggle="pill"
                                            href="#pills-4"
                                            role="tab"
                                            aria-controls="pills-4"
                                            aria-selected="false"
                                            >
                                            Other
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <div class="d-flex">
                                <li class="nav-item mx-1 border-left">
                                    <a
                                        class="nav-link p-3 ude-btnHoverHeaderCircle"
                                        href="viewBooking.jsp"
                                        >
                                        <img src="./img/booking.png" width="20" alt="">
                                    </a>
                                </li>
                                <li
                                    style="
                                    width: 25px;
                                    height: 25px;
                                    background-color: #ec5252;
                                    color: white;
                                    font-size: 16px;
                                    "
                                    class="rounded-circle mr-2"
                                    >
                                    <span style="margin: 8.5px;">
                                        <%
                                            ListRequestDTO list = (ListRequestDTO) session.getAttribute("list");
                                            if (list != null) {
                                                if (list.getList().values().size() > 9) {
                                        %>        
                                        9+
                                        <%
                                        } else {
                                        %>
                                        <%= list.getList().values().size()%>
                                        <%
                                            }
                                        } else {
                                        %>
                                        0
                                        <%
                                            }
                                        %>
                                    </span>
                                </li>

                                <li class="nav-item ude-btnGroup d-flex">
                                    <a href="HistoryRequestController"><button class="btn btn-warning mr-3 mt-1">History</button></a>
                                    <form action="MainController" method="POST">     
                                        <button class="ude-btnWhite" style="width: 250px">
                                            Welcome, ${sessionScope.FULLNAME} !
                                        </button>
                                        <button type="submit" name="action" value="Logout" class="ude-btnRed">Log Out</button>
                                    </form>
                                </li>
                            </div>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <hr>
        <section class="bodyUser">
            <div class="container">
                <form action="MainController" method="POST">
                    <input type="hidden" name="txtRoleID" value="${sessionScope.ROLEID}" />
                    <input type="date" name="txtDate" value="${param.txtDate}">
                    <button type="submit"
                            name="action"
                            value="SearchDateProduct"
                            class="ude-btnHoverbgSearch">
                        <div class="input-group-append button my-1">
                            <span
                                class="input-group-text ude-btnHoverSearch"
                                id="basic-addon2"
                                ><i class="fa fa-search"></i
                                ></span>
                        </div>
                    </button>
                </form>

                <div class="tab-content" id="pills-tabContent">
                    <div
                        class="tab-pane fade show active"
                        id="pills-1"
                        role="tabpanel"
                        aria-labelledby="pills-1-tab"
                        >
                        <div class="row my-4">
                            <c:if test="${requestScope.INFOUS != null}" var="info">
                                <c:forEach var="dto" items="${requestScope.INFOUS}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                            <c:if test="${!info}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTUS}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                            <!--                            LD-->
                            <c:if test="${requestScope.INFOLD != null}" var="info2">
                                <c:forEach var="dto" items="${requestScope.INFOLD}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>


                            <c:if test="${!info2}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTLD}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>

                    <div
                        class="tab-pane fade"
                        id="pills-2"
                        role="tabpanel"
                        aria-labelledby="pills-2-tab"
                        >
                        <div class="row my-4">
                            <c:if test="${requestScope.PRODUCTLISTUSE != null}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTUSE}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                            <c:if test="${requestScope.PRODUCTLISTLDE != null}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTLDE}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>

                    <div
                        class="tab-pane fade"
                        id="pills-3"
                        role="tabpanel"
                        aria-labelledby="pills-3-tab"
                        >
                        <div class="row my-4">
                            <c:if test="${requestScope.PRODUCTLISTUSI != null}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTUSI}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                            <c:if test="${requestScope.PRODUCTLISTLDI != null}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTLDI}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>

                    <div
                        class="tab-pane fade"
                        id="pills-4"
                        role="tabpanel"
                        aria-labelledby="pills-4-tab"
                        >
                        <div class="row my-4">
                            <c:if test="${requestScope.PRODUCTLISTUSO != null}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTUSO}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                            <c:if test="${requestScope.PRODUCTLISTLDO != null}">
                                <c:forEach var="dto" items="${requestScope.PRODUCTLISTLDO}">
                                    <div class="col-3 my-3">
                                        <div class="card">
                                            <div class="card-img">
                                                <img src="${dto.image}" height="200" width="100%" alt="..."></img>
                                            </div>
                                            <div class="card-body p-0">
                                                <div class="card-body-content font-weight-bold">
                                                    <h5 class="card-title">${dto.productName}</h5>
                                                    <p class="mb-0">Quantity: ${dto.quantity}</p>
                                                    <p class="mb-0">Color: ${dto.color}</p>
                                                    <p class="">Date created: ${dto.createProductDate}</p>
                                                </div>
                                                <div class="card-body-btn">
                                                    <form action="MainController" method="POST">
                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                        <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                        <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                                        <input type="hidden" name="txtQuantityRequest" value="${dto.quantityRequest}" />
                                                        <input type="hidden" name="txtImage" value="${dto.image}" />
                                                        <input type="hidden" name="txtColor" value="${dto.color}" />
                                                        <button class="btn" type="submit" name="action" value="AddList">
                                                            <p class="btn-buy">BOOKING</p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>

                </div>

                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:if test="${requestScope.NUMBERPAGEUS != null}">
                            <c:forEach begin="1" end="${requestScope.NUMBERPAGEUS}" var="index">
                                <li class="page-item"><a class="page-link" href="PagingController?txtRoleID=US&index=${index}">${index}</a></li>
                                </c:forEach>  
                            </c:if>
                            <c:if test="${requestScope.NUMBERPAGELD != null}">
                                <c:forEach begin="1" end="${requestScope.NUMBERPAGELD}" var="index">
                                <li class="page-item"><a class="page-link" href="PagingController?txtRoleID=LD&index=${index}">${index}</a></li>
                                </c:forEach>  
                            </c:if>
                    </ul>
                </nav>
            </div>
        </section>
        <footer>
            <div class="footer__content">
                <div class="row footer__rowSecond py-3">
                    <div class="col-12 col-md-1 footer__img">
                        <div class="footer__logo">
                            <img src="img/logoLPD.jpg" alt="logoLPD" />
                        </div>
                    </div>
                    <div class="col-12 col-md-9 footer__hr__content">
                        <h6>LPD COMPANY</h6>
                        <p>
                            Address : 208 Nguyen Huu Canh, Ward 22, Binh Thanh District, Ho Chi Minh City.
                        </p>
                        <p>
                            Certificate of business registration number: 0101659783, <br> 30th change registration, 22 month
                            01 year 2020 by the Department of Planning and Investment of Ho Chi Minh City.
                        </p>
                        <p>Hotline: 0974 359 136</p>
                        <p>
                            Email: <a href="#" class="footer__email">lp.duy2k@gmail.com</a>
                        </p>
                    </div>
                    <div class="col-12 col-md-2 footer__img">
                        <div class="footer__BoCo mb-5">
                            <a
                                href="http://online.gov.vn/Home/WebDetails/62782?AspxAutoDetectCookieSupport=1"
                                >
                                <img
                                    src="img/thongbaobocongthuong.jpg"
                                    alt="logoBoCongThuong"
                                    />
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
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
    </body>
</html>

