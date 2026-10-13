<%@ include file="/html/public/common/header.jsp" %>

<form action="/DemoWebApp/controller/public/participante)" method="post">
	<input type="hidden" name="action" value="login">
	<label for="login">E-mail:</label>
	<input type="email" name="login" placeholder="ex: user@gmail.com"/>
	<label for="password">Password:</label>
	<input type="password" name="password"/>
	<input type="submit" value="Entrar"/>
</form>

<%@ include file="/html/public/common/footer.jsp" %>