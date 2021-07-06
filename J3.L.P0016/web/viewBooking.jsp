<%-- 
    Document   : viewBooking
    Created on : May 21, 2021, 1:11:13 AM
    Author     : Le Phuoc Duy
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="duylp.dtos.ProductDTO"%>
<%@page import="duylp.dtos.ListRequestDTO"%>
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
        <link rel="stylesheet" href="./css/viewCart.css" />
    </head>
    <body style="background-color: #EED8DE; height: 100%;">
        <%
            ListRequestDTO list = (ListRequestDTO) session.getAttribute("list");
        %>
        <div class="viewCart">
            <form action="MainController" method="POST">
                <div class="modal-dialog modal-xl modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">
                                <%
                                    if (list != null) {
                                %>
                                <%= list.getName()%>'s
                                <%
                                    }
                                %>
                            </h5>
                            <div>
                                <font color="red">
                                ${requestScope.requestError}
                                </font>
                            </div>
                                <a href="SearchProductController?txtRoleID=${sessionScope.ROLEID}&txtSearch=" style="text-align: right; color: red">Back to Home page<i class="fa fa-undo ml-2"></i></a>
                        </div>
                        <div class="modal-body">
                            <div class="bgTable">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col"></th>
                                            <th scope="col">Product</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Color</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            if (list != null) {
                                                int count = 0;
                                                for (ProductDTO dto : list.getList().values()) {
                                                    count++;
                                        %>
                                        <tr>
                                            <th scope="row"><%= count%></th>
                                            <td><img height="110" width="110" src="<%= dto.getImage()%>" alt=""></td>
                                            <td style="font-weight: bold;"><%= dto.getProductName()%></td>
                                            <td>
                                                <input type="hidden" name="txtProductID" value="<%= dto.getProductID()%>" />
                                                <div class="buttons_added">
                                                    <input class="minus is-form px-2" type="button" value="-">
                                                    <input readonly aria-label="quantity" class="input-qty" max="10" min="1" name="txtQuantityRequest" type="number" value="<%= dto.getQuantityRequest()%>">
                                                    <input class="plus is-form" type="button" value="+">
                                                </div>
                                            </td>
                                            <td><%= dto.getColor()%></td>
                                            <td><input type="checkbox" name="chkRemove" value="<%= dto.getProductID()%>" /></td>
                                        </tr>
                                        <%
                                                }
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">  
                            <jsp:useBean id="minDate"  class="java.util.Date"></jsp:useBean>
                                Booking until: 
                                <input class="ml-2" type="date" min="<fmt:formatDate pattern = "yyyy-MM-dd"  value="${minDate}"/>" name="bookingUntil" value="2021-06-01">
                            <button type="submit" name="action" value="Booking" class="btn btn-warning ml-3">BOOKING</button>                       
                            <button type="submit" name="action" value="UpdateList" class="btn btn-primary">
                                UPDATE
                            </button>
                            <button type="submit" name="action" value="RemoveList" class="btn btn-danger"><i class="fa fa-trash-alt mr-2"></i>DELETE</button>
                        </div>
                    </div>
                </div>
            </form>
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
        <script>
            $('input.input-qty').each(function () {
                var $this = $(this),
                        qty = $this.parent().find('.is-form'),
                        min = Number($this.attr('min')),
                        max = Number($this.attr('max'))
                if (min == 0) {
                    var d = 0
                } else
                    d = min
                $(qty).on('click', function () {
                    if ($(this).hasClass('minus')) {
                        if (d > min)
                            d += -1
                    } else if ($(this).hasClass('plus')) {
                        var x = Number($this.val()) + 1
                        if (x <= max)
                            d += 1
                    }
                    $this.attr('value', d).val(d)
                })
            })
        </script>
    </body>
</html>
