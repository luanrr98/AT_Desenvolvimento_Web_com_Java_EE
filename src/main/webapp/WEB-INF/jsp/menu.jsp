<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/info">Biblioteca</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/disc">Home</a></li>
            <c:if test="${not empty resp}">

                <li><a href="/responsaveis">Responsavel</a></li>
                <li><a href="/requerentes">Requerente</a></li>
                <li><a href="/midias">Midias</a>></li>
                <li><a href="/bibliotecas">Biblioteca</a></li>
                <li><a href="/mangas">Manga</a></li>
                <li><a href="/animes">Anime</a></li>
                <li><a href="/jogos">Jogo</a></li>
            </c:if>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty resp}">
                <li><a href="/responsavel"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
            </c:if>
            <c:if test="${empty resp}">
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
            </c:if>
            <c:if test="${not empty resp}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>LogOut, ${resp.nome}</a></li>
            </c:if>
        </ul>
    </div>
</nav>



