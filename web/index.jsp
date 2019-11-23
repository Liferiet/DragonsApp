<%--
  Created by IntelliJ IDEA.
  User: Liferiet
  Date: 04.09.2019
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>My dragon app!</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<div class="container">
  <div class="d-flex justify-content-center mt-2">
    <div class="p-2">
      <h1>Moje male smoczki</h1>
    </div>
  </div>
  <div class="d-flex justify-content-center">
    <img src="resources/wild-dragon.jpg" width="798" height="525" alt="Dragon image">
  </div>
  <div class="d-flex flex-row justify-content-around">
    <div class="p-2">
      <form action="<c:url value="/login"/>" method="get">
        <button type="submit" class="btn btn-primary">Login</button>
      </form>
    </div>
    <div class="p-2">
      <form action="<c:url value="/signUp"/>" method="get">
        <button type="submit" class="btn btn-primary">Nowe konto</button>
      </form>
    </div>
  </div>


</div>





<%--    <form action="login" method="post">
      <p>
        <input type="submit" value="Login">
      </p>
    </form>--%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>