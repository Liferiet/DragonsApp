<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Liferiet
  Date: 06.09.2019
  Time: 04:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="st" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%
    User user = (User)session.getAttribute("user");
%>
HOME<br>
Email: <%= user.getEmail() %>

<div class="container">
    <div class="row">
        <div class="col-1" name="menu">
            <div class="row">
                Dodaj smoka
            </div>
            <div class="row">
                Menu 2
            </div>
            <div class="row">
                Menu 3
            </div>
            <div class="row">
                Menu 4
            </div>
        </div>
        <div class="col" name="siteContent" style="background-color: darkgreen">
            <c:choose>
                <c:when test="${ user.dragonList == null }">
                    Stworz swoje smoki
                </c:when>
                <c:otherwise>
                    <c:forEach items="${ user.dragonList }" var="dragon" varStatus="loop">
                        <st:dragonFragment dragonName="${dragon.name}" strength="${dragon.strength}"
                                           agility="${dragon.agility}" intelligence="${dragon.intelligence}"
                                           vitality="${dragon.vitality}"/>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>

</body>
</html>
