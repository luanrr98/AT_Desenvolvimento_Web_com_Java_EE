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

    <a href="/biblioteca">Adicionar Biblioteca</a>
    <hr>

    <c:if test="${not empty msg}">
        <div class="alert alert-danger">
            <h5> Falha no Cadastramento: ${msg}</h5>
        </div>
    </c:if>

    <c:if test="${not empty titulo}">
        <div class="alert alert-success">
            <h5>Biblioteca "${titulo}" cadastrada com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaBibliotecas}">
        <h4>Listagem de Bibliotecas (${listaBibliotecas.size()}):</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Visibilidade</th>
                <th>Data e Hora Criacao</th>
                <th>Requerente</th>
                <th>Midias</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="b" items="${listaBibliotecas}">
                <tr>
                    <td>${b.id}</td>
                    <td>${b.titulo}</td>
                    <td>${b.visibilidade}</td>
                    <td>${b.dataHoraCriacaoFormatada}</td>
                    <td>${b.requerente.nome}</td>
                    <td>${b.midias.size()}</td>

                    <td><a href="/biblioteca/excluir/${b.id}">Excluir</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaBibliotecas}">
        <h4>Nenhuma Biblioteca Cadastrada</h4>
    </c:if>
</div>

</body>
</html>
