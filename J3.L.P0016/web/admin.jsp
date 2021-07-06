<%-- 
    Document   : admin
    Created on : May 18, 2021, 12:37:48 AM
    Author     : Le Phuoc Duy
--%>

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
                    <form class="form-inline my-2 my-lg-0" action="MainController" method="POST">
                        <div>
                            <select class="btn btn-primary mr-2" name="cbxSearchStatus">
                                <option 
                                    <c:if test="${dto.statusRequestID eq 'New'}"> 
                                    selected="true"
                                    </c:if> 
                                    value="New" > New
                                </option>
                                <option 
                                    <c:if test="${dto.statusRequestID eq 'Delete'}">
                                    selected="true"
                                    </c:if> 
                                    value="Delete" > Delete
                                </option> 
                                <option 
                                    <c:if test="${dto.statusRequestID eq 'Accept'}">
                                    selected="true"
                                    </c:if> 
                                    value="Accept" > Accept
                                </option>
                            </select>
                        </div>
                        <input
                            class="form-control mr-sm-2"
                            type="text"
                            name="txtSearchEmail"
                            placeholder="Search email"
                            aria-label="Search"
                            />
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="SearchRequest">
                            Search
                        </button>
                    </form>
                </div>
                <div class="col-3 my-3">
                    <form action="MainController" method="POST"> 
                        <span class="">Welcome, ${sessionScope.FULLNAME} !</span>
                        <button type="submit" name="action" value="Logout" class="btn btn-danger mx-2">Log Out</button>
                    </form>
                </div>
            </div>
            <hr />
            <div class="container">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Email</th>
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
                                <td>${dto.email}</td>
                                <td>${dto.bookDate}</td>
                                <td>${dto.bookingUntil}</td>
                                <td>
                                    <select name="cbxStatus" 
                                            <c:if test="${dto.statusRequestID eq 'Delete'}">
                                            disabled
                                            </c:if> 
                                        >   
                                        <option 
                                            <c:if test="${dto.statusRequestID eq 'New'}"> 
                                            selected="true"
                                            </c:if> 
                                            value="New" > New
                                        </option>
                                        <option 
                                            <c:if test="${dto.statusRequestID eq 'Delete'}">
                                            selected="true"
                                            </c:if> 
                                            value="Delete" > Delete
                                        </option>
                                        <option 
                                            <c:if test="${dto.statusRequestID eq 'Accept'}">
                                            selected="true"
                                            </c:if> 
                                            value="Accept" > Accept
                                        </option>
                                    </select>
                                </td>
                                <td>
                                    <button style="padding: 2px; font-size: 14px" class="btn btn-warning" name="action" value="UpdateRequest" type="submit">Update</button>
                                </td>
                                <td>
                                    <button style="padding: 2px; font-size: 14px" class="btn btn-danger" name="action" value="RequestDetail" type="submit">View Details</button>
                                </td>
                            </tr>
                            </form>
                        </c:forEach>
                    </c:if>

                    <c:if test="${!info}">
                        <c:forEach var="dto" items="${requestScope.REQUESTLIST}">
                            <form action="MainController" method="POST">
                            <tr>
                                <th>${dto.requestID}
                                <input type="hidden" name="txtRequestID" value="${dto.requestID}" />
                                </th>
                                <td>${dto.email}</td>
                                <td>${dto.bookDate}</td>
                                <td>${dto.bookingUntil}</td>
                                <td>
                                    <select name="cbxStatus" 
                                            <c:if test="${dto.statusRequestID eq 'Delete'}">
                                            disabled
                                            </c:if> 
                                        >
                                        <option 
                                            <c:if test="${dto.statusRequestID eq 'New'}"> 
                                            selected="true"
                                            </c:if> 
                                            value="New" > New
                                        </option>
                                        <option 
                                            <c:if test="${dto.statusRequestID eq 'Delete'}">
                                            selected="true"
                                            </c:if> 
                                            value="Delete" > Delete
                                        </option>
                                        <option 
                                            <c:if test="${dto.statusRequestID eq 'Accept'}">
                                            selected="true"
                                            </c:if> 
                                            value="Accept" > Accept
                                        </option>
                                    </select>
                                </td>
                                <td>
                                    <button style="padding: 2px; font-size: 14px" class="btn btn-warning" name="action" value="UpdateRequest" type="submit">Update</button>
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

