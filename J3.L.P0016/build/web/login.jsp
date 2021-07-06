<%-- 
    Document   : login
    Created on : May 18, 2021, 12:36:03 AM
    Author     : Le Phuoc Duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>LPD</title>
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
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <!-- Recaptcha -->
    <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
    
    <link rel="stylesheet" href="./css/login.css" />
  </head>
  <body>
    <div class="login">
      <c:if test="${requestScope.ERROR != null}" var="alert">
        <div
          class="alert ${requestScope.COLOR} alert-dismissible fade show"
          role="alert"
        >
          <strong>${requestScope.ERROR}</strong>
          <button
            type="button"
            class="close"
            data-dismiss="alert"
            aria-label="Close"
          >
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
      </c:if>
      <c:if test="${!alert}">
        <div></div>
      </c:if>
      <div id="logreg-forms">
        <form class="form-signin" action="MainController" method="POST">
          <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
            Sign in
          </h1>
          <div class="social-login">
            <a
                class="btn google-btn social-btn"
                href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/LPD/LoginGoogleController&response_type=code
                               &client_id=206843261145-pn8ugapln7olg5harvt1nhkcs1jtva2n.apps.googleusercontent.com&approval_prompt=force"
            >
              <span
                ><i class="fab fa-google-plus-g"></i> Sign in with Google+</span
              >
            </a>
          </div>
          <p style="text-align: center">OR</p>
          <input
            type="text"
            name="txtEmail"
            class="form-control"
            placeholder="Email"
            value="${param.txtEmail}"
          />
          <div style="height: 22px">
            <font color="red" class="ml-1">
              ${requestScope.INVALID.emailError}
            </font>
          </div>
          <input
            type="password"
            name="txtPassword"
            class="form-control"
            placeholder="Password"
          />
          <div style="height: 22px">
            <font color="red" class="ml-1">
              ${requestScope.INVALID.passwordError}
            </font>
          </div>
          <div class="g-recaptcha" data-sitekey="6LcFK38aAAAAACA1W7em5b1GedlWdqFPeqqMyfPG"></div>
          <div style="height: 22px">
            <font color="red" class="ml-1">
               ${requestScope.INVALID.captchaError}
            </font>
          </div>
          <button
            class="btn btn-success btn-block"
            type="submit"
            name="action"
            value="Login"
          >
            <i class="fas fa-sign-in-alt"></i> Sign in
          </button>
          <hr />
          <a
            class="btn btn-primary btn-block text-white"
            type="button"
            id="btn-signup"
            href="createUser.jsp"
          >
            Sign up New Account
          </a>
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

