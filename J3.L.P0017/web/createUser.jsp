<%-- 
    Document   : createUser
    Created on : Jun 9, 2021, 11:04:20 PM
    Author     : Le Phuoc Duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>LPD2</title>
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <!-- Font As -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="./css/createUser.css" />
    </head>
    <body>
        <div class="login">
            <div id="logreg-forms" class="logreg-forms2">
                <form class="form-signin" action="createUser" method="POST" enctype="multipart/form-data">
                    <input type="text" 
                           name="txtNewUserID" 
                           class="form-control" 
                           placeholder="UserID" 
                           value="${param.txtNewUserID}"
                           />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newUserIDError}
                        </font>
                    </div>
                    <input type="text" 
                           name="txtNewUserName" 
                           class="form-control" 
                           placeholder="User Name" 
                           value="${param.txtNewUserName}"
                           />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newUserNameError}
                        </font>
                    </div>
                    <input
                        type="password"
                        name="txtNewPassword"
                        class="form-control"
                        placeholder="Password"/>
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newPasswordError}
                        </font>
                    </div>
                    <input
                        type="password"
                        name="txtNewConfirm"
                        class="form-control"
                        placeholder="Confirm Password" />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newConfirmError}
                        </font>
                    </div>
                    <input type="text" 
                           name="txtNewEmail" 
                           class="form-control" 
                           placeholder="Email" 
                           value="${param.txtNewEmail}"
                           />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newEmailError}
                        </font>
                    </div>
                    <input type="text" 
                           name="txtNewPhoneNumber" 
                           class="form-control" 
                           placeholder="Phone Number" 
                           value="${param.txtNewPhoneNumber}"
                           />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newPhoneNumberError}
                        </font>
                    </div>
                    <input type="file" class="form-control" name="newPhoto">
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newPhotoError}
                        </font>
                    </div>
                    <select name="cbxNewRole">
                        <c:forEach var="roleList" items="${sessionScope.ROLELIST}">
                            <option value="${roleList.roleID}">${roleList.roleName}</option>
                        </c:forEach>
                    </select>
                    <button
                        class="btn btn-primary btn-block"
                        id="btn-signup"
                        type="submit"
                        value="CreateUser"
                        > CREATE
                    </button>
                    <a href="search?txtSearch=" style="text-align: right;">Back to page<i class="fa fa-undo ml-2"></i></a>
                </form>
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
