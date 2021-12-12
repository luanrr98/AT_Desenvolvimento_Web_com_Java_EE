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

    <a href="/requerente">Adicionar Requerente</a>
    <hr>

    <c:if test="${not empty msg}">
        <div class="alert alert-danger">
            <h5> Falha na Exclusão: ${msg}</h5>
        </div>
    </c:if>

    <c:if test="${not empty nome}">
        <div class="alert alert-success">
            <h5>Requerente ${nome} cadastrado com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaRequerentes}">
        <h4>Listagem de Requerentes (${listaRequerentes.size()}):</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Apelido</th>
                <th>Responsavel</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="r" items="${listaRequerentes}">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.nome}</td>
                    <td>${r.email}</td>
                    <td>${r.apelido}</td>
                    <td>${r.responsavel.nome}</td>
                    <td><a href="/requerente/excluir/${r.id}">Excluir</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaRequerentes}">
        <h4>Nenhum Requerente Cadastrado</h4>
    </c:if>
</div>

</body>
</html>
