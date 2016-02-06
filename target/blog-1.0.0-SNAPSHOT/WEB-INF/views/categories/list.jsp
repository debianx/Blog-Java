<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pagetemplate bodyClass="" title="">
	${sucesso}
	<c:forEach items="${categories}" var="categories">
	${categories.id }
${categories.name}
${categories.description}
	</c:forEach>
</customTags:pagetemplate>