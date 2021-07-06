<%-- 
    Document   : newDetail
    Created on : May 26, 2021, 1:09:43 PM
    Author     : Le Phuoc Duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="./css/viewCart.css" />
    </head>
    <body>
        <div class="viewCart">
            <div class="modal-dialog modal-xl modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">
                                ID request: ${sessionScope.REQUESTID}
                            </h5>
                                <%
                                    String roleID = (String)session.getAttribute("ROLEID");
                                   if (roleID.equals("AD")) {
                                %>
                                    <a href="PagingAdminController?index=1" style="text-align: right; color: red">Back to Home page<i class="fa fa-undo ml-2"></i></a>
                                <%
                                    } else {
                                %>
                                    <a href="PagingController?index=1" style="text-align: right; color: red">Back to Home page<i class="fa fa-undo ml-2"></i></a>
                                <%
                                    }
                                %>
                    </div>
                    <div class="modal-body">
                        <div class="bgTable">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col"></th>
                                        <th scope="col">Product</th>
                                        <th scope="col">Color</th>
                                        <th scope="col">Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${requestScope.REQUESTDETAILLIST != null}">
                                        <c:forEach var="dto" items="${requestScope.REQUESTDETAILLIST.listProduct}" varStatus="counter">
                                        <tr>
                                            <th>${counter.count}</th>
                                            <td><img height="110" width="110" src="${dto.image}" alt=""></td>
                                            <td>${dto.productName}</td>
                                            <td>${dto.color}</td>
                                            <td>${dto.quantityRequest}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
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
    </body>
</html>
