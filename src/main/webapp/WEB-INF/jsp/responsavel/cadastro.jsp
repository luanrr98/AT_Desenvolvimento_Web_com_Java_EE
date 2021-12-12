<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Biblioteca de Midias</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <form action="/cep" class="form-inline" method="post">
        <div class="form-group">
            <label>Cep:</label>
            <input value="01503-000" type="text" class="form-control" name="cep" placeholder="Digite o seu CEP">
        </div>
        <input type="submit" class="btn btn-primary" value="Buscar">

        <hr>


    </form>


    <form action="/responsavel/incluir" method="post">

        <div class="form-group">
            <label>Nome:</label>
            <input type="text" class="form-control" value="Ai Enma" name="nome" required>
        </div>

        <div class="form-group">
            <label>Email:</label>
            <input type="email" class="form-control" value="enmaai@mail.com" name="email" required>
        </div>

        <div class="form-group">
            <label>Idade:</label>
            <input type="number" class="form-control" value="2000" name="idade" required>
        </div>

        <div class="form-group">
            <label>Senha:</label>
            <input type="password" class="form-control" value="123" name="senha" required>
        </div>

        <c:import url="/WEB-INF/jsp/endereco.jsp"/>


        <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>
</div>


</body>
</html>
