<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autenticar</title>
</head>
<body>
	<h1>Autenticar usuário</h1>
	<form action="/jdt-jsp2/authServlet?urlRequisitada=<%= request.getParameter("urlRequisitada") %>" method="post">
		<input type="text" name="login" id="login" placeholder="username" value="${ usuarioForm.login }">
		<input type="password" name="senha" id="senha" placeholder="senha" value="${ usuarioForm.senha }">

		<button type="submit">Logar</button>
	</form>

	<c:if test="${ not empty errorMessage }">
		<span style="color: red;}">${ errorMessage }</span>
	</c:if>
</body>
</html>