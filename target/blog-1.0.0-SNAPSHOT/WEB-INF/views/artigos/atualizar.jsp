<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pagetemplate bodyClass="" title="">
Atualizar o Artigo ${artigos.id}
${artigos.categories}
</p>
<table>
<c:url var="addArtigo" value="/artigos/update">
</c:url>
<form:form action="${addArtigo}" commandName="artigos">
<tr>
<form:label path="id">
	<spring:message text="ID"/>
</form:label>
<form:input path="id" readonly="true" size="5" disable="true"/>
<form:hidden path="id"/>
<td>
<form:input path="title"/>
</td>
</tr>
<tr>
<td>
<form:textarea path="body"/>
</td>
</tr>
<tr>
<td>
<input type="submit" value="Alterar">
</td>
</tr>
</form:form>
</table>
</customTags:pagetemplate>