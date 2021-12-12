<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Biblioteca de Mídias</title>
</head>
<body>
<c:import url="menu.jsp"/>
<div class="container">
    <h3>Dados do Sistema</h3>
    <div class="list-group">
    <c:forEach var="m" items="${map}">
        <li class="list-group-item">${m.key} <span class="badge">${m.value}</span></li>
    </c:forEach>
    </div>
</div>


</body>
</html>