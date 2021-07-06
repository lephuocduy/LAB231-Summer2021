<%-- 
    Document   : history
    Created on : May 24, 2021, 8:03:42 PM
    Author     : Le Phuoc Duy
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>LPD</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
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
    </head>
    <body>
        <div>
            <div class="row mt-3">
                <div class="col-9 d-flex">
                    <img class="mx-5" src="./img/logoLPD.jpg" width="80" />
                    <div class="mt-3">
                        <jsp:useBean id="maxDate"  class="java.util.Date"></jsp:useBean>
                        <form action="MainController" method="POST">
                        Search date: <input type="date" max="<fmt:formatDate pattern = "yyyy-MM-dd"  value="${maxDate}"/>" name="txtSearchBookDate" value="${param.txtSearchBookDate}">
                        <button type="submit" name="action" value="SearchHistoryRequest"><i
                        class="fa fa-search"></i></button>
                        <input type="hidden" name="txtEmail" value="${sessionScope.EMAIL}" />
                        </form>
                    </div>
                </div>
                <div class="col-3 my-3">
                    <a href="SearchProductController?txtRoleID=${sessionScope.ROLEID}&txtSearch=" style="text-align: right;">Back to Home page <i class="fa fa-undo ml-2"></i></a>
                </div>
            </div>
            <hr />
            <div class="container">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Book date</th>
                            <th scope="col">Booking until</th>
                            <th scope="col">Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:if test="${requestScope.INFOREQ != null}" var="info">
                        <c:forEach var="dto" items="${requestScope.INFOREQ}">
                        <form action="MainController" method="POST"> 
                            <tr>
                                <th>${dto.requestID}
                                <input type="hidden" name="txtRequestID" value="${dto.requestID}" />
                                </th>
                                <td>${dto.bookDate}</td>
                                <td>${dto.bookingUntil}</td>
                                <td>${dto.statusRequestID}</td>
                                <td>
                                    <button 
                                        <c:if test="${dto.statusRequestID eq 'Accept'}">
                                            disabled ="true"
                                        </c:if> 
                                        style="padding: 2px; font-size: 14px" class="btn btn-warning" name="action" value="DeleteRequest" type="submit">Delete</button>
                                </td>
                                <td>
                                    <button style="padding: 2px; font-size: 14px" class="btn btn-danger" name="action" value="RequestDetail" type="submit">View Details</button>
                                </td>
                            </tr>
                        </form>
                        </c:forEach>
                    </c:if>

                    <c:if test="${!info}">
                        <c:forEach var="dto" items="${requestScope.REQUESTHISTORYLIST}">
                        <form action="MainController" method="POST"> 
                            <tr>
                                <th>${dto.requestID}
                                <input type="hidden" name="txtRequestID" value="${dto.requestID}" />
                                </th>
                                <td>${dto.bookDate}</td>
                                <td>${dto.bookingUntil}</td>
                                <td>${dto.statusRequestID}</td>
                                <td>
                                    <button
                                        <c:if test="${dto.statusRequestID eq 'Accept'}">
                                            disabled ="true"
                                        </c:if> 
                                        style="padding: 2px; font-size: 14px" class="btn btn-warning" name="action" value="DeleteRequest" type="submit">Delete</button>
                                </td>
                                <td>
                                    <button style="padding: 2px; font-size: 14px" class="btn btn-danger" name="action" value="RequestDetail" type="submit">View Details</button>
                                </td>
                            </tr>
                        </form>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:if test="${requestScope.NUMBERPAGEREQ != null}">
                            <c:forEach begin="1" end="${requestScope.NUMBERPAGEREQ}" var="index">
                                <li class="page-item"><a class="page-link" href="PagingAdminController?index=${index}">${index}</a></li>
                            </c:forEach>  
                        </c:if>
                    </ul>
                </nav>
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
    </body>
</html>

