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

    <form action="/jogo/incluir" method="post">

        <div class="form-group">
            <label>Nome:</label>
            <input type="text" class="form-control" value="Shantae" name="nome" required>
        </div>

        <div class="form-group">
            <label>Genero:</label>
            <input type="text" class="form-control" value="Aventura" name="genero" required>
        </div>

        <div class="form-group">
            <label>Engine:</label>
            <input type="text" class="form-control" value="Aventura" name="engine" required>
        </div>

        <div class="form-group">
            <label>Nota:</label>
            <input type="number" class="form-control" value="10.0" name="nota" required>
        </div>

        <div class="form-group">
            <div class="form-check-inline">
                <label>
                    Baseado em Outra Midia: <input type="checkbox" class="form-check-input" value="true"
                                                   name="baseadoOutraMidia">
                </label>
            </div>
        </div>

        <div class="form-group">
            <div class="form-check-inline">
                <label>
                    Multijogador: <input type="checkbox" class="form-check-input" value="true"
                                         name="multijogador">
                </label>
            </div>
        </div>


        <div class="form-group">
            <label>Frequencia Lancamento:</label>
            <select class="form-control" name="plataforma">
                <option value="PC">PC</option>
                <option value="XBOX">Xbox</option>
                <option value="PS5">PS5</option>
                <option value="SWITCH">SWITCH</option>


            </select>

            <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>
</div>


</body>
</html>
