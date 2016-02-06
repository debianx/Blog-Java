<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pagetemplate bodyClass="" title="">
<form:form action="${spring:mvcUrl('saveArtigo').build()}" class="pure-form pure-form-stacked" method="post" commandName="artigo" >
<fieldset>
<legend>Cadastrar Artigo</legend>
<div class="pure-g">
	<div class="pure-u-1 pure-u-md-1-3">
		<label for="title">Titulo</label>
		<form:input path="title" class="pure-u-23-24"/>
		<form:errors path="title"></form:errors>
	</div>
	<div class="pure-u-1 pure-u-md-1-3">
		<label for="categories.id">Categoria</label>
		<form:select path="categories.id">
			<c:forEach var="categories" items="${categories}">
				<option value="${categories.id}">${categories.name}</option>
			</c:forEach>
		</form:select>
	</div>
</div>
	<label for="body">Conteúdo</label>
		<form:textarea path="body"  class="pure-input-1-2" placeholder="Textareas work too"/>
		<form:errors path="body"></form:errors>
		
	<button type="submit"  class="pure-button pure-button-primary">Enviar</button>
</fieldset>
</form:form>
</customTags:pagetemplate>