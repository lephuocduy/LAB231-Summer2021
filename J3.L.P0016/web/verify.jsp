<%-- 
    Document   : verify
    Created on : May 19, 2021, 12:10:27 AM
    Author     : Le Phuoc Duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>LPD</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body style="background-image: url('./img/verifyEmail.jpg'); background-size: 100%; height: 100%;">
        <h1 class="" style="color: white; margin-top: 100px; text-align: center;">We already send a verification  code to your email.</h1>
        <form action="MainController" method="POST">
            <div class="" style="margin-left: 42%; width: 250px">
                <div class="input-group mb-3">
                    <input type="text" name="authCode" class="form-control" placeholder="Code">
                    <input type="hidden" name="txtNewEmail" value="${sessionScope.NEWEMAIL}" />
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" style="color: white" type="submit" id="button-addon2" name="action" value="UserVerify">Verify</button>
                    </div>
                </div>
            </div>
        </form>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
