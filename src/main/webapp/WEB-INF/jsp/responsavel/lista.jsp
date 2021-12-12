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
    <c:if test="${not empty nome}">
        <div class="alert alert-success">
            <h5>Responsavel ${nome} cadastrado com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaResponsaveis}">
        <h4>Listagem de Responsaveis (${listaResponsaveis.size()}):</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Idade</th>
                <th>Requerentes</th>
                <th>Midias</th>
                <th>Bibliotecas</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="r" items="${listaResponsaveis}">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.nome}</td>
                    <td>${r.email}</td>
                    <td>${r.idade}</td>
                    <td>${r.requerentes.size()}</td>
                    <td>${r.midias.size()}</td>
                    <td>${r.bibliotecas.size()}</td>
                    <td><a href="/responsavel/excluir/${r.id}">
                        <c:choose>
                            <c:when test="${resp.id != r.id}">
                                Excluir
                            </c:when>
                        </c:choose>
                    </a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaResponsaveis}">
        <h4>Nenhum Responsavel Cadastrado</h4>
    </c:if>
</div>


</body>
</html>
