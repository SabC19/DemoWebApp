<%@ include file="/html/public/common/header.jsp" %>

<%
	ActividadDTO actividad = (ActividadDTO) request.getAttribute("actividad");
	out.println("<h1>" + actividad.getNombre() + "</h1>");
	out.println("<p>" + actividad.getDescripcion() + "</p>");
	
%>
<%@ include file="/html/public/common/footer.jsp" %>