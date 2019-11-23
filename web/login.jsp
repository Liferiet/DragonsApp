<%--
  Created by IntelliJ IDEA.
  User: Liferiet
  Date: 03.09.2019
  Time: 02:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bigstyle.css">

<%--    <script>
        async function main() {
            var x = await fetch ("header.html");
            var html = await x.text();
            document.querySelector("#headerPlaceholder").innerHTML = html;
        }
    </script>--%>

</head>
<body>

<div class="container">

<%--    <div id="headerPlaceholder" class="row" style="background-color: pink">Tekst</div>--%>
    <%@ include file="header.jsp"%>

    <div class="row login-error-message ">
        <%=(request.getAttribute("errLoginFormat") == null) ? "" : request.getAttribute("errLoginFormat")%>
    </div>

    <div class="row">
        <div id="firstRow" class="col" style="background-color: lightblue">

        </div>
        <div class="col-6" style="background-color: white">
            <form action="<c:url value="/login"/>" method="post">
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="email" class="form-control" name="email" id="inputEmail" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
        <div class="col" style="background-color: lightblue">

        </div>
    </div>

    <%@ include file="footer.jsp"%>

</div>



<%--<script>
    main();
</script>--%>


</body>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>