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

    <form action="/manga/incluir" method="post">

        <div class="form-group">
            <label>Nome:</label>
            <input type="text" class="form-control" value="Tomie" name="nome" required>
        </div>

        <div class="form-group">
            <label>Genero:</label>
            <input type="text" class="form-control" value="Horror" name="genero" required>
        </div>

        <div class="form-group">
            <label>Quantidade de Capitulos:</label>
            <input type="number" class="form-control" value="20" name="quantidadeCapitulos" required>
        </div>

        <div class="form-group">
            <label>Quantidade de Volumes:</label>
            <input type="number" class="form-control" value="1" name="quantidadeVolumes" required>
        </div>

        <div class="form-group">
            <label>Nota:</label>
            <input type="number" class="form-control" value="10.0" name="nota" required>
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
            <label>Frequencia Lancamento:</label>
            <select class="form-control" name="frequenciaEstimadaLancamento">
                <option value="Quinzenal">Quinzenal</option>
                <option value="Mensal">Mensal</option>
            </select>

            <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>
</div>


</body>
</html>
