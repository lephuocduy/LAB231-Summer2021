<%-- 
    Document   : admin
    Created on : Jun 9, 2021, 12:21:40 AM
    Author     : Le Phuoc Duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPD2</title>
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
        <link rel="stylesheet" href="./css/admin.css" />
    </head>
    <body>
        <header>
            <c:if test="${requestScope.ERROR != null}" var="alert">
                <div
                    class="alert alert-danger alert-dismissible fade show"
                    role="alert"
                    style="position: fixed; z-index: 9999; margin-top: 100px;"
                    >
                    <strong>${requestScope.ERROR}</strong>
                    <button
                        type="button"
                        class="close"
                        data-dismiss="alert"
                        aria-label="Close"
                        >
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <nav class="navbar navbar-expand-lg">
                <div class="col-7">
                    <div class="header__left">
                        <a class="navbar-brand mr-0" href="#">
                            <img src="./img/logoLPD.jpg" alt="" />
                        </a>
                        <form action="search" method="POST" class="header__form align-self-center ml-5"> 
                            <div class="input-group ml-2" style="height: 100%; width: 400px;">
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
                                        value="Search"
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
                <div class="col-5 px-0">
                    <div class="header__right">
                        <ul class="navbar-nav mr-auto">
                            <div class="d-flex">
                                <li class="nav-item ude-btnGroup d-flex">
                                    <form action="promotionList" method="POST">    
                                        <button class="btn btn-warning mx-3 mt-1" type="submit" name="action" value="PromotionList">Promotion list</button>        
                                    </form>
                                    <form action="logout" method="POST">    
                                        <button class="ude-btnWhite" style="width: 250px">
                                            Welcome, ${sessionScope.USERID} !
                                        </button>
                                        <button type="submit" value="Logout" class="ude-btnRed">Log Out</button>
                                    </form>
                                </li>
                            </div>
                        </ul>
                    </div>
                </div>
            </nav>
            <nav class="navbar navbar-expand-lg">
                <div class="col-6 col-md-7 col-lg-7 col-xl-7 px-0">
                    <div class="header__right">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item business">
                                <ul class="nav nav-pills" id="pills-tab" role="tablist">
                                    <li class="nav-item">
                                        <a
                                            class="nav-link p-3 ude-btnHoverHeader"
                                            href="search?txtSearch="
                                            >
                                            <i class="fa fa-th"></i>
                                            All
                                        </a>
                                    </li>
                                    <c:forEach var="roleList" items="${sessionScope.ROLELIST}" varStatus="counter">
                                        <li class="nav-item">  
                                            <a
                                                class="nav-link p-3 ude-btnHoverHeader"
                                                href="roleUserList?txtRole=${roleList.roleID}"
                                                >  
                                                ${roleList.roleName}
                                            </a>
                                        </li>      
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <hr>
        <section class="bodyUser">
            <div style="width: 95%; margin: 0 auto;">
                <div>
                    <div class="font-weight-bold mb-3" style="float: left">
                        Insert Role
                        <a
                            href="insert"
                            >
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                    <div class="font-weight-bold mb-3" style="float: right">
                        Create User
                        <a
                            href="create"
                            >
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="tab-content" id="pills-tabContent">
                    <div>
                        <table class="table"> 
                            <thead>
                                <tr>
                                    <th scope="col">#
                                        <div style="height: 28px"></div>
                                    </th>
                                    <th scope="col">Photo
                                        <div style="height: 28px"></div>                                    
                                    </th>
                                    <th scope="col">User ID
                                        <div style="height: 28px"></div>                                    
                                    </th>
                                    <th scope="col">User name
                                        <div style="height: 28px; width: 134px">
                                            <font color="red" class="ml-1">
                                            ${requestScope.INVALID.newUserNameError}
                                            </font>
                                        </div>
                                    </th>
                                    <th scope="col">Email
                                        <div style="height: 28px; width: 155px">
                                            <font color="red" class="ml-1">
                                            ${requestScope.INVALID.newEmailError}
                                            </font>
                                        </div>                                    
                                    </th>
                                    <th scope="col">Phone number
                                        <div style="height: 28px; width: 181px">
                                            <font color="red" class="ml-1">
                                            ${requestScope.INVALID.newPhoneNumberError}
                                            </font>
                                        </div>                                    
                                    </th>
                                    <th scope="col">Role
                                        <div style="height: 28px"></div>                                   
                                    </th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${requestScope.INFO != null}" var="info">
                                    <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                                        <tr>
                                    <form action="updateUser" method="POST" enctype="multipart/form-data"> 
                                        <td>${counter.count}</td>
                                        <td>
                                            <img width="100" height="100" src="./img/${dto.photo}"> 
                                            <input type="file" style="padding: 0.375rem 1.25rem; margin-left: -0.5rem; border: none" class="form-control" name="newPhoto">
                                            <input type="hidden" name="photo" value="${dto.photo}" />
                                        </td>
                                        <td>${dto.userID}
                                            <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewUserName" value="${dto.userName}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewEmail" value="${dto.email}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewPhoneNumber" value="${dto.phoneNumber}" />
                                        </td>
                                        <td>
                                            <c:if test="${dto.roleID eq 'AD'}"> 
                                                <input type="hidden" name="cbxNewRole" value="AD" />
                                            </c:if> 
                                            <select name="cbxNewRole"
                                                    <c:if test="${dto.roleID eq 'AD'}"> 
                                                        disabled="true"
                                                    </c:if>    
                                                    >  
                                                <c:forEach var="roleList" items="${sessionScope.ROLELIST}">
                                                    <option 
                                                        <c:if test="${dto.roleID eq roleList.roleID}"> 
                                                            selected="true"
                                                        </c:if> 
                                                        value="${roleList.roleID}" > ${roleList.roleName}
                                                    </option>                                                
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>                                               
                                            <c:if test="${(dto.roleID ne 'AD') || (dto.userID eq sessionScope.USERID)}"> 
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-warning" value="UpdateUser" type="submit">Update</button>
                                            </c:if>                                                
                                        </td>
                                    </form>
                                        <td>
                                            <c:if test="${(dto.roleID ne 'AD') || (dto.userID eq sessionScope.USERID)}">
                                                <a href="change?txtUserID=${dto.userID}" style="padding: 2px; font-size: 14px" class="btn btn-secondary">Change Password</a> 
                                            </c:if>                                                                                                       
                                        </td>
                                    <form action="deleteUser" method="POST"> 
                                        <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        <td>
                                            <c:if test="${dto.roleID ne 'AD'}">
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-primary" value="DeleteUser" type="submit">Delete</button> 
                                            </c:if>                                                                                                       
                                        </td>
                                    </form>
                                    <form action="addPromotion" method="POST"> 
                                        <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        <td>                                                
                                            <c:if test="${dto.roleID ne 'AD'}"> 
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-danger" value="AddPromotion" type="submit">Add Promotion</button>
                                            </c:if>                                                         
                                        </td>
                                    </form>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${!info}">
                                <c:forEach var="dto" items="${requestScope.ROLEUSERLIST}" varStatus="counter">
                                    <tr>
                                    <form action="updateUser" method="POST" enctype="multipart/form-data"> 
                                        <td>${counter.count}</td>
                                        <td>
                                            <img width="100" height="100" src="./img/${dto.photo}"> 
                                            <input type="file" style="padding: 0.375rem 1.25rem; margin-left: -0.5rem; border: none" class="form-control" name="newPhoto">
                                            <input type="hidden" name="photo" value="${dto.photo}" />
                                        </td>
                                        <td>${dto.userID}
                                            <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewUserName" value="${dto.userName}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewEmail" value="${dto.email}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewPhoneNumber" value="${dto.phoneNumber}" />
                                        </td>
                                        <td>
                                            <c:if test="${dto.roleID eq 'AD'}"> 
                                                <input type="hidden" name="cbxNewRole" value="AD" />
                                            </c:if> 
                                            <select name="cbxNewRole"
                                                    <c:if test="${dto.roleID eq 'AD'}"> 
                                                        disabled="true"
                                                    </c:if>    
                                                    >  
                                                <c:forEach var="roleList" items="${sessionScope.ROLELIST}">
                                                    <option 
                                                        <c:if test="${dto.roleID eq roleList.roleID}"> 
                                                            selected="true"
                                                        </c:if> 
                                                        value="${roleList.roleID}" > ${roleList.roleName}
                                                    </option>                                                
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>                                               
                                            <c:if test="${(dto.roleID ne 'AD') || (dto.userID eq sessionScope.USERID)}"> 
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-warning" value="UpdateUser" type="submit">Update</button>
                                            </c:if>                                                
                                        </td>
                                    </form>
                                        <td>
                                            <c:if test="${(dto.roleID ne 'AD') || (dto.userID eq sessionScope.USERID)}">
                                                <a href="change?txtUserID=${dto.userID}" style="padding: 2px; font-size: 14px" class="btn btn-secondary">Change Password</a> 
                                            </c:if>                                                                                                       
                                        </td>
                                    <form action="deleteUser" method="POST"> 
                                        <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        <td>
                                            <c:if test="${dto.roleID ne 'AD'}">
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-primary" value="DeleteUser" type="submit">Delete</button> 
                                            </c:if>                                                                                                       
                                        </td>
                                    </form>
                                    <form action="addPromotion" method="POST"> 
                                        <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        <td>                                                
                                            <c:if test="${dto.roleID ne 'AD'}"> 
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-danger" value="AddPromotion" type="submit">Add Promotion</button>
                                            </c:if>                                                         
                                        </td>
                                    </form>
                                    </tr>
                                </c:forEach>
                            </c:if>
                                    
                            <c:if test="${requestScope.LIST != null}">
                                <c:forEach var="dto" items="${requestScope.LIST}" varStatus="counter">
                                    <tr>
                                    <form action="updateUser" method="POST" enctype="multipart/form-data"> 
                                        <td>${counter.count}</td>
                                        <td>
                                            <img width="100" height="100" src="./img/${dto.photo}"> 
                                            <input type="file" style="padding: 0.375rem 1.25rem; margin-left: -0.5rem; border: none" class="form-control" name="newPhoto">
                                            <input type="hidden" name="photo" value="${dto.photo}" />
                                        </td>
                                        <td>${dto.userID}
                                            <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewUserName" value="${dto.userName}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewEmail" value="${dto.email}" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtNewPhoneNumber" value="${dto.phoneNumber}" />
                                        </td>
                                        <td>
                                            <c:if test="${dto.roleID eq 'AD'}"> 
                                                <input type="hidden" name="cbxNewRole" value="AD" />
                                            </c:if> 
                                            <select name="cbxNewRole"
                                                    <c:if test="${dto.roleID eq 'AD'}"> 
                                                        disabled="true"
                                                    </c:if>    
                                                    >  
                                                <c:forEach var="roleList" items="${sessionScope.ROLELIST}">
                                                    <option 
                                                        <c:if test="${dto.roleID eq roleList.roleID}"> 
                                                            selected="true"
                                                        </c:if> 
                                                        value="${roleList.roleID}" > ${roleList.roleName}
                                                    </option>                                                
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>                                               
                                            <c:if test="${(dto.roleID ne 'AD') || (dto.userID eq sessionScope.USERID)}"> 
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-warning" value="UpdateUser" type="submit">Update</button>
                                            </c:if>                                                
                                        </td>
                                    </form>
                                        <td>
                                            <c:if test="${(dto.roleID ne 'AD') || (dto.userID eq sessionScope.USERID)}">
                                                <a href="change?txtUserID=${dto.userID}" style="padding: 2px; font-size: 14px" class="btn btn-secondary">Change Password</a> 
                                            </c:if>                                                                                                       
                                        </td>
                                    <form action="deleteUser" method="POST"> 
                                        <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        <td>
                                            <c:if test="${dto.roleID ne 'AD'}">
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-primary" value="DeleteUser" type="submit">Delete</button> 
                                            </c:if>                                                                                                       
                                        </td>
                                    </form>
                                    <form action="addPromotion" method="POST"> 
                                        <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                        <td>                                                
                                            <c:if test="${dto.roleID ne 'AD'}"> 
                                                <button style="padding: 2px; font-size: 14px" class="btn btn-danger" value="AddPromotion" type="submit">Add Promotion</button>
                                            </c:if>                                                         
                                        </td>
                                    </form>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
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
