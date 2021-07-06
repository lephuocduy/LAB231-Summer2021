<%-- 
    Document   : user
    Created on : Jun 9, 2021, 12:21:49 AM
    Author     : Le Phuoc Duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>LPD2</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="./css/user.css">

    </head>
    <body>
        <div>
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img width="80" src="./img/logoLPD.jpg">
                </a>
                <div class="d-flex">
                    <form action="historyList" method="POST">   
                        <button class="btn btn-warning" type="submit" value="HistoryList">History</button>  
                    </form>
                    <form action="logout" method="POST">                      
                        Welcome, ${sessionScope.USERNAME} !
                        <button type="submit" value="Logout" class="btn btn-danger">Log Out</button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="container my-5">
            <div class="row">
                <div class="col-4">
                    <img width="250" height="300" src="./img/${sessionScope.PHOTO}" alt="">
                </div>
                <div class="col-8">
                    <p class="font-weight-bold">Email: <span class="font-weight-normal">${sessionScope.EMAIL}</span></p>
                    <p class="font-weight-bold">Phone number: <span class="font-weight-normal">${sessionScope.PHONENUMBER}</span></p>
                    <font color="${sessionScope.COLOR}" class="font-weight-bold">
                        ${sessionScope.STATUS}
                    </font>
                </div>
            </div>
        </div>
        <footer>
            <div class="footer__content">
                <div class="row footer__rowSecond py-3">
                    <div class="col-12 col-md-1 footer__img">
                        <div class="footer__logo">
                            <img width="80" src="img/logoLPD.jpg" alt="logoLPD" />
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
