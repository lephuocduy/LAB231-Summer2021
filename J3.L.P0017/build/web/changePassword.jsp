<%-- 
    Document   : changePassword
    Created on : Jun 18, 2021, 9:34:56 PM
    Author     : Le Phuoc Duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>LPD2</title>
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
        <!-- Font As -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="./css/login.css" />
    </head>
    <body>
        <div class="login">
            <div id="logreg-forms">
                <form class="form-signin" action="changePassword" method="POST">
                    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
                        Change the password for userID: ${param.txtUserID}
                    </h1>
                    <input
                        type="password"
                        name="txtOldPassword"
                        class="form-control"
                        placeholder="Old Password"
                        />
                    <div style="height: 30px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.oldPasswordError}
                        </font>
                    </div>
                    <input
                        type="password"
                        name="txtNewPassword"
                        class="form-control"
                        placeholder="New Password"
                        />
                    <div style="height: 30px">
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
                    <input type="hidden" name="txtUserID" value="${param.txtUserID}" />
                    <button
                        class="btn btn-success btn-block"
                        type="submit"
                        value="ChangePassword"
                        >
                        Change
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
