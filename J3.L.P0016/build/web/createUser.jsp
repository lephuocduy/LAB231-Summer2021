<%-- 
    Document   : createUser
    Created on : May 18, 2021, 11:08:14 PM
    Author     : Le Phuoc Duy
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <title>LPD</title>
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <!-- Font As -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <link rel="stylesheet" href="./css/login.css" />
    </head>
    <body>
        <div class="login">
            <div id="logreg-forms" class="logreg-forms2">
                <form class="form-signin" action="MainController" method="POST">
                    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
                        Sign up
                    </h1>
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
                           name="txtNewFullname" 
                           class="form-control" 
                           placeholder="Full Name" 
                           value="${param.txtNewFullname}"
                           />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newFullnameError}
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
                        placeholder="Confirm password" />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newConfirmError}
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
                    <input type="text" 
                           name="txtNewAddress" 
                           class="form-control" 
                           placeholder="Address" 
                           value="${param.txtNewAddress}"
                           />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.newAddressError}
                        </font>
                    </div>
                    <button
                        class="btn btn-primary btn-block"
                        id="btn-signup"
                        type="submit"
                        value="CreateUser"
                        name="action"
                        > SIGN UP
                    </button>
                    <a href="login.jsp" style="text-align: right;">Back to Login page<i class="fa fa-undo ml-2"></i></a>
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

