<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Biblioteca de Midias</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <c:if test="${not empty msg}">
        <div class="alert alert-danger">
            <h5> Falha na Exclusão: ${msg}</h5>
        </div>
    </c:if>

    <c:if test="${not empty nome}">
        <div class="alert alert-success">
            <h5>Midia ${nome} cadastrada com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaMidias}">
        <h4>Listagem de Requerentes (${listaMidias.size()}):</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Genero</th>
                <th>Baseado em Outra Midia</th>
                <th>Nota</th>
                <th>Dias Producao</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="m" items="${listaMidias}">
                <tr>
                    <td>${m.id}</td>
                    <td>${m.nome}</td>
                    <td>${m.genero}</td>
                    <td>${m.baseadoOutraMidia}</td>
                    <td>${m.nota}</td>
                    <td>${m.quantidadeDiasProducao()}</td>

                    <td><a href="/midia/excluir/${m.id}">Excluir</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaMidias}">
        <h4>Nenhuma Midia Cadastrado</h4>
    </c:if>
</div>

</body>
</html>
