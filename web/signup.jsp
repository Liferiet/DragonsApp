<%--
  Created by IntelliJ IDEA.
  User: Liferiet
  Date: 04.09.2019
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<%--    <script>
        function validate()
        {
            var username = document.form.email.value;
            var password = document.form.password.value;
            var nickname = document.form.nickname.value;

            if (username==null || username=="")
            {
                alert("Username cannot be blank");
                return false;
            }
            else if(password==null || password=="")
            {
                alert("Password cannot be blank");
                return false;
            } else if(nickname==null || nickname=="") {
                alert("Nickname cannot be blank")
                return false;
            }
        }
    </script>--%>
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-4">
        <div class="col-5 row align-items-center">
            <img class="my-img" src="resources/wildSingleDragon.jpg" width="371" height="525" alt="Dragon image">
        </div>
        <div class="col-5 row align-items-center">
                <form name="form" action="<c:url value="/signUp"/>" onsubmit="return validate()" method="post">
                    <div class="p-2">
                        Rejestracja konta
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Email">
                        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" id="inputPassword1" placeholder="Haslo" <%--minlength="8" maxlength="30"--%>>
                    </div>
                    <div>
                        <input type="text" class="form-control" name="nickname" id="inputUsername" placeholder="Nickname">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block mt-3">Utworz konto</button>
                </form>
        </div>
    </div>


</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
