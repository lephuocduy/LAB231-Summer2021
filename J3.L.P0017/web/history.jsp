<%-- 
    Document   : history
    Created on : Jun 9, 2021, 11:05:21 PM
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
            <div class="">
                <div class="mt-3 ml-4">
                    <img class="" width="80" src="./img/logoLPD.jpg" alt="" />
                </div> 
                <div class="text-center display-4 font-weight-bold">
                    HISTORY
                </div>
            </div>
        </header>
        <hr>
        <section class="bodyUser">
            <div style="width: 95%; margin: 0 auto;">
                <div>
                    <div style="float: left">
                        <font color="${requestScope.COLOR}">
                            ${requestScope.STATUS}
                        </font>
                    </div>
                    <div class="font-weight-bold mb-3" style="float: right">
                        <a href="user" style="text-align: right;">Back to page<i class="fa fa-undo ml-2"></i></a>
                    </div>
                </div>
                <table class="table"> 
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Promotion date</th>
                            <th scope="col">Rank</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${requestScope.HISTORYLIST != null}">
                            <c:forEach var="dto" items="${requestScope.HISTORYLIST}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.historyDate}</td>
                                <td>${dto.historyRank}</td>
                            </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
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
