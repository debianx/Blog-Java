<!doctype html>
<%@tag import="br.com.blog.dao.ArtigoDao"%>
<%@tag import="br.com.blog.model.Artigo"%>
<%@attribute name="title" required="true"%>
<%@attribute name="bodyClass" required="true"%>
<%@attribute name="extraScripts" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Blog EDUOLIOLI</title>
	<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">

<!--[if lte IE 8]>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">

<![endif]-->
<!--[if gt IE 8]><!-->

<link rel="stylesheet"
href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">

<!--<![endif]-->

<!--[if lte IE 8]>
<link rel="stylesheet" href="css/layouts/blog-old-ie.css">
<![endif]-->
<!--[if gt IE 8]><!-->
<link rel="stylesheet"
href="<c:url value="/resources/css/layouts/blog.css" />" media="screen">
<!--<![endif]-->
<body>
	<div id="layout" class="pure-g">
	
		<div class="sidebar pure-u-1 pure-u-md-1-4">
			<div class="header">
				<h1 class="brand-title">BLOG EDUOLIOLI</h1>
				<div class="pure-menu custom-restricted-width">
    <span class="pure-menu-heading">Categorias</span>
    <ul class="pure-menu-list">
        <c:forEach var="categories" items="${categories}">
        <li class="pure-menu-item">${categories.name}</li>
		</c:forEach>
        </ul>
		</div>
			</div>
			<p class="social">
                      <a href="http://facebook.com/rochacbruno">
                          <i class="fa fa-facebook fa-3x"></i>
                        </a>
                        </p>
		</div>
		<div class="content pure-u-1 pure-u-md-3-4">
			<div>
				<jsp:doBody />
			</div>

<display:table name="artigos" requestURI="" pagesize="5">
  <display:column property="title" title="ID" />
  <display:column property="body" />
</display:table>
			
		</div>


</body>
</html>








