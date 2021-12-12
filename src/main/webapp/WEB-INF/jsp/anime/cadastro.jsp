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

    <form action="/anime/incluir" method="post">

        <div class="form-group">
            <label>Nome:</label>
            <input type="text" class="form-control" value="Mayoiga" name="nome" required>
        </div>

        <div class="form-group">
            <label>Genero:</label>
            <input type="text" class="form-control" value="Suspense" name="genero" required>
        </div>

        <div class="form-group">
            <label>Quantidade de Episodios:</label>
            <input type="number" class="form-control" value="20" name="numeroEpisodios" required>
        </div>

        <div class="form-group">
            <label>Quantidade de Temporadas:</label>
            <input type="number" class="form-control" value="1" name="numeroTemporadas" required>
        </div>

        <div class="form-group">
            <label>Nota:</label>
            <input type="number" class="form-control" value="7.3" name="nota" required>
        </div>

        <div class="form-group">
            <div class="form-check-inline">
                <label>
                    Baseado em Outra Midia:<input type="checkbox" class="form-check-input" value="true"
                                                  name="baseadoOutraMidia">
                </label>
            </div>
        </div>

        <div class="form-group">
            <label>Tipo de Animacao:</label>
            <select class="form-control" name="tipoAnimacao">
                <option value="2D">2D</option>
                <option value="3D">3D</option>
            </select>

            <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>
</div>


</body>
</html>
