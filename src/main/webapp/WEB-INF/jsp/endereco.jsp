<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${not empty endereco.logradouro}">
    <div class="form-group">
        <label>Logradouro</label>
        <input class="form-control" name="logradouro" value="${endereco.logradouro}" required type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.logradouro}">
    <div class="form-group">
        <label>Logradouro</label>
        <input class="form-control" name="logradouro" placeholder="Informe seu logradouro" required type="text">
    </div>
</c:if>

<div class="form-group">
    <label>Número da Residência:</label>
    <input class="form-control" name="numero" placeholder="Infome seu número" required type="text">
</div>
<div class="form-group">
    <label>Complemento</label>
    <input class="form-control" name="complemento" placeholder="Infome um complemento" required type="text">
</div>
<c:if test="${not empty endereco.bairro}">
    <div class="form-group">
        <label>Bairro</label>
        <input class="form-control" name="bairro" value="${endereco.bairro}" required type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.bairro}">
    <div class="form-group">
        <label>Bairro</label>
        <input class="form-control" name="bairro" placeholder="Informe seu bairro" required type="text">
    </div>
</c:if>

<c:if test="${not empty endereco.localidade}">
    <div class="form-group">
        <label>Localidade</label>
        <input class="form-control" name="localidade" value="${endereco.localidade}" required type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.localidade}">
    <div class="form-group">
        <label>Localidade</label>
        <input class="form-control" name="localidade" placeholder="Informe sua localidade" required type="text">
    </div>
</c:if>

<c:if test="${not empty endereco.uf}">
    <div class="form-group">
        <label>UF</label>
        <input class="form-control" name="uf" value="${endereco.uf}" required type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.uf}">
    <div class="form-group">
        <label>UF</label>
        <input class="form-control" name="uf" placeholder="Informe sua UF" required type="text">
    </div>
</c:if>
<c:if test="${not empty endereco.cep}">
    <div class="form-group">
        <label>CEP</label>
        <input class="form-control" name="cep" value="${endereco.cep}" required type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.cep}">
    <div class="form-group">
        <label>CEP</label>
        <input class="form-control" name="cep" placeholder="Informe seu CEP" required type="text">
    </div>
</c:if>