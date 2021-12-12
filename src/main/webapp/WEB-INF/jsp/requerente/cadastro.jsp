<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Biblioteca de Midias</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <form action="/requerente/incluir" method="post">

        <div class="form-group">
            <label>Nome:</label>
            <input type="text" class="form-control" value="Pedro Bardock" name="nome" required>
        </div>

        <div class="form-group">
            <label>Email:</label>
            <input type="email" class="form-control" value="pbardock@mail.com" name="email" required>
        </div>

        <div class="form-group">
            <label>Apelido:</label>
            <input type="text" class="form-control" value="BDock" name="apelido" required>
        </div>


        <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>
</div>


</body>
</html>
