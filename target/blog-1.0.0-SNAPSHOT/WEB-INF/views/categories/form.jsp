<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pagetemplate bodyClass="" title="">
<form:form servletRelativeAction="/admin/categories/save" cssClass="categories">
 <div>
 <label>Nome da categoria
 <input type="text" name="name">
 </label>
</div>
<div>
<label>Descrição
<input type="text" name="description"/>
</label>
</div>
 <div>
 <input name="submit" type="submit">
 </div>
</form:form>
</customTags:pagetemplate>