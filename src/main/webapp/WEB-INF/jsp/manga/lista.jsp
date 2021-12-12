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

    <a href="/manga">Adicionar Manga</a>
    <hr>
    <c:if test="${not empty msg}">
        <div class="alert alert-danger">
            <h5> Falha na Exclusão: ${msg}</h5>
        </div>
    </c:if>

    <c:if test="${not empty nome}">
        <div class="alert alert-success">
            <h5>Manga ${nome} cadastrado com sucesso</h5>
        </div>
    </c:if>

    <c:if test="${not empty listaMangas}">
        <h4>Listagem de Mangas (${listaMangas.size()}):</h4>
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
            <c:forEach var="m" items="${listaMangas}">
                <tr>
                    <td>${m.id}</td>
                    <td>${m.nome}</td>
                    <td>${m.genero}</td>
                    <td>${m.baseadoOutraMidia}</td>
                    <td>${m.quantidadeCapitulos}</td>
                    <td>${m.quantidadeVolumes}</td>
                    <td>${m.frequenciaEstimadaLancamento}</td>
                    <td>${m.nota}</td>
                    <td>${m.quantidadeDiasProducao()}</td>

                    <td><a href="/manga/excluir/${m.id}">Excluir</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty listaMangas}">
        <h4>Nenhum Manga Cadastrado</h4>
    </c:if>
</div>

</body>
</html>
