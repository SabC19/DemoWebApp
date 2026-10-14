<%@ include file="/html/public/common/header.jsp" %>
<%@ include file="/html/private/actividad/actividad-search.jsp" %>

<!-- Resultados de Busqueda -->
<c:set var="results" value="${requestScope[AttributeNames.RESULTS]}" /> <!-- Equivalente: "${requestScope.results" !-->

<c:if test="${not empty results }">
	<p>Encontrados ${results.total} resultados</p>
	<ol>
		<c:forEach var="e" items="${results.page}">
			<li>${e.nombre}</li>
		</c:forEach>
	</ol>
</c:if>

<%@ include file="/html/public/common/footer.jsp" %>