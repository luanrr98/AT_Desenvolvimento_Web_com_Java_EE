<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${not empty endereco.logradouro}">
    <div class="form-group">
        <label>Logradouro</label>
        <input class="form-control" name="logradouro" value="${endereco.logradouro}"  type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.logradouro}">
    <div class="form-group">
        <label>Logradouro</label>
        <input class="form-control" name="logradouro" placeholder="Informe seu logradouro"  type="text">
    </div>
</c:if>

<div class="form-group">
    <label>Numero da Residencia:</label>
    <input class="form-control" name="numero" placeholder="Infome seu número" value="616" type="text">
</div>
<div class="form-group">
    <label>Complemento</label>
    <input class="form-control" name="complemento" placeholder="Infome um complemento" value="Casa marrom" type="text">
</div>
<c:if test="${not empty endereco.bairro}">
    <div class="form-group">
        <label>Bairro</label>
        <input class="form-control" name="bairro" value="${endereco.bairro}"  type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.bairro}">
    <div class="form-group">
        <label>Bairro</label>
        <input class="form-control" name="bairro" placeholder="Informe seu bairro"  type="text">
    </div>
</c:if>

<c:if test="${not empty endereco.localidade}">
    <div class="form-group">
        <label>Localidade</label>
        <input class="form-control" name="localidade" value="${endereco.localidade}"  type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.localidade}">
    <div class="form-group">
        <label>Localidade</label>
        <input class="form-control" name="localidade" placeholder="Informe sua localidade"  type="text">
    </div>
</c:if>

<c:if test="${not empty endereco.uf}">
    <div class="form-group">
        <label>UF</label>
        <input class="form-control" name="uf" value="${endereco.uf}"  type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.uf}">
    <div class="form-group">
        <label>UF</label>
        <input class="form-control" name="uf" placeholder="Informe sua UF"  type="text">
    </div>
</c:if>
<c:if test="${not empty endereco.cep}">
    <div class="form-group">
        <label>CEP</label>
        <input class="form-control" name="cep" value="${endereco.cep}"  type="text" readonly>
    </div>
</c:if>
<c:if test="${empty endereco.cep}">
    <div class="form-group">
        <label>CEP</label>
        <input class="form-control" name="cep" placeholder="Informe seu CEP"  type="text">
    </div>
</c:if>