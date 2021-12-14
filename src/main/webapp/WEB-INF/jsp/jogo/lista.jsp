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

    <a href="/jogo">Adicionar Jogo</a>
    <hr>
    <c:if test="${not empty msg}">
        <div class="alert alert-danger">
            <h5> Falha na Exclusão: ${msg}</h5>
        </div>
    </c:if>

    <c:if test="${not empty nome}">
        <div class="alert alert-success">
            <h5>Jogo ${nome} cadastrado com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaJogos}">
        <h4>Listagem de Jogos (${listaJogos.size()}):</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Genero</th>
                <th>Baseado em Outra Midia</th>
                <th>Plataforma</th>
                <th>Engine</th>
                <th>Multijogador</th>
                <th>Nota</th>
                <th>Dias Producao</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="j" items="${listaJogos}">
                <tr>
                    <td>${j.id}</td>
                    <td>${j.nome}</td>
                    <td>${j.genero}</td>
                    <td>${j.baseadoOutraMidia}</td>
                    <td>${j.plataforma}</td>
                    <td>${j.engine}</td>
                    <td>${j.multijogador}</td>
                    <td>${j.nota}</td>
                    <td>${j.quantidadeDiasProducao()}</td>

                    <td><a href="/jogo/excluir/${j.id}">Excluir</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaJogos}">
        <h4>Nenhum Jogo Cadastrado</h4>
    </c:if>
</div>

</body>
</html>
