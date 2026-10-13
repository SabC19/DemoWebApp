<%@ page language="java" contentType="text/html"; charset="UTF-8" pageEncoding="UTF-8"%>

<%@page import="com.sabic.explorworld.model.*"%>
<%@page import="com.jal.ecommerce.util.*"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div id="user-menu">
	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<a href="/DemoWebApp/html/public/participante/login.jsp">Autenticarse</a>
		</c:when>
		<c:otherwise>
			<a href="/DemoWebApp/participante?action=logout">Salir</a>
			<a href="/DemoWebApp/html/participante/participante-detail.jsp">${sessionScope.user.nombre}</a>
		</c:otherwise>
	</c:choose>
</div>