<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Cadastro</title>
</head>
<body>
<c:import url="menu.jsp"/>

<div class="container">
    <c:if test="${not empty msg}">
        <div class="alert alert-warning">
            <h3><strong>${msg}</strong> </h3>
        </div>
    </c:if>

    <form action="/login" method="post">

        <div class="form-group">
            <label>Email:</label>
            <input type="email" class="form-control" value="enma@mail.com" name="email" required>
        </div>

        <div class="form-group">
            <label>Senha:</label>
            <input type="password" class="form-control" value="123" name="senha" required>
        </div>

        <input type="submit" value="Realizar Login" class="btn btn-primary">
    </form>
</div>


</body>
</html>
