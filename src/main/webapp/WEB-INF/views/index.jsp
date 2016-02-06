	<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
	<customTags:pagetemplate bodyClass="" title="">

	<c:forEach items="${artigos}" var="artigo">
	<!-- A wrapper for all the blog posts -->
	<div class="posts">
		<!-- A single blog post -->
		<section class="post">
			<header class="post-header">
				<h2 class="post-title">${artigo.title}</h2>
				<p class="post-meta">Autor</p>
			</header>

			<div class="post-description">
			${fn:substring(artigo.body, 0,500)}
			</div>
		</section>
		<hr>
	</div>

	</c:forEach>
	
	</customTags:pagetemplate>