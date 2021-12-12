<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.appbiblioteca.model.domain.Requerente" %>
<%@page import="java.util.List" %>
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

    <a href="/anime">Adicionar Anime</a>
    <hr>
    <c:if test="${not empty msg}">
        <div class="alert alert-danger">
            <h5> Falha na Exclusão: ${msg}</h5>
        </div>
    </c:if>

    <c:if test="${not empty nome}">
        <div class="alert alert-success">
            <h5>Anime ${nome} cadastrado com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaAnimes}">
        <h4>Listagem de Animes (${listaAnimes.size()}):</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Genero</th>
                <th>Baseado em Outra Midia</th>
                <th>Quantidade De Capitulos</th>
                <th>Quantidade De volumes</th>
                <th>Frequencia de Lancamento</th>
                <th>Nota</th>
                <th>Dias Producao</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="a" items="${listaAnimes}">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.nome}</td>
                    <td>${a.genero}</td>
                    <td>${a.baseadoOutraMidia}</td>
                    <td>${a.numeroEpisodios}</td>
                    <td>${a.numeroTemporadas}</td>
                    <td>${a.tipoAnimacao}</td>
                    <td>${a.nota}</td>
                    <td>${a.quantidadeDiasProducao()}</td>

                    <td><a href="/anime/excluir/${a.id}">Excluir</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaAnimes}">
        <h4>Nenhum Anime Cadastrado</h4>
    </c:if>
</div>

</body>
</html>
