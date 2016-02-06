<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pagetemplate bodyClass="" title="">


${sucesso}</br>

<c:forEach items="${artigos}" var="artigo">

<b>Titulo:${artigo.title}</b>
<br>
conteudo:${artigo.body}<br>
categoria:${artigo.categories.name}<br>
${artigo.categories.id}
${artigo.categories.description}
<br>
<a href="<c:url value='/admin/artigos/atualizar/${artigo.id}'/>">Atualizar</a>||
<a href="<c:url value='/admin/artigos/remove/${artigo.id}'/>">Remover</a>
<hr>
</c:forEach>
</customTags:pagetemplate>