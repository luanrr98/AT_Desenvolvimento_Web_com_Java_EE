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

    <form action="/biblioteca/incluir" method="post">

        <div class="form-group">
            <label>Titulo:</label>
            <input type="text" class="form-control" value="Biblioteca do BDock" name="titulo" required>
        </div>

        <div class="form-group">
            <label>Visibilidade:</label>
            <input type="text" class="form-control" value="Privada" name="visibilidade" required>
        </div>

        <div class="form-group">
            <c:if test="${not empty midias}">
                <label>Midias:</label>
                <c:forEach var="m" items="${midias}">
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <input type="checkbox" name="midiaIds" class="form-check-input" value="${m.id}"
                                   name="titulo"> ${m.nome}
                        </label>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty midias}">
                <label>Nenhuma Midia Cadastrada</label>
                <c:set var="botao" value="disabled"/>
            </c:if>
        </div>

        <div class="form-group">
            <c:if test="${not empty requerentes}">
                <label>Requerente:</label>
                <select class="form-control" name="requerente.id">
                    <c:forEach var="r" items="${requerentes}">
                        <option value="${r.id}">${r.nome}</option>
                    </c:forEach>
                </select>

            </c:if>
            <c:if test="${empty requerentes}">
                <label>Nenhum Requerente Cadastrado</label>
                <c:set var="botao" value="disabled"/>
            </c:if>
        </div>


        <input type="submit" ${botao} value="Cadastrar" class="btn btn-primary">
    </form>
</div>


</body>
</html>
