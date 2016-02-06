<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
    
<customTags:pagetemplate bodyClass="" title="">

	<a href="${spring:mvcUrl('AC#form').build()}">Cadastrar Artigo</a>
	<a href="${spring:mvcUrl('CC#form').build()}">Cadastrar Categoria</a>
	</customTags:pagetemplate>