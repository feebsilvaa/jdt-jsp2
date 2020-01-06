<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Envio e-mail</title>
</head>
<body>
	<h1>Enviar e-mail.</h1>

	<form action="/jdt-jsp2/sendMailServlet" method="post">

	
	<jsp:include page="menu-pages.jsp" />
		
		<br>
		<br>
		<br>
		
		<table>
			<tr>
				<td><label for="destinatario">Destinatário: </label></td>
				<td><input type="email" id="destinatario" name="destinatario"
					value="${ mailForm.to }" placeholder="mail@server.com"></td>
			</tr>
			<tr>
				<td><label for="assunto">Assunto: </label></td>
				<td><input type="text" id="assunto" name="assunto"
					value="${ mailForm.subject }"></td>
			</tr>
			<tr>
				<td><label for="corpo_email">Corpo: </label></td>
				<td><textarea id="corpo_email" name="corpo_email" rows="10"
						cols="100" style="resize: none;"><c:out
							value="${ mailForm.body }"></c:out></textarea></td>
			</tr>
		</table>
		<button type="submit">Enviar</button>
	</form>

	<c:if test="${ not empty errorMessage }">
		<span style="color: red;">${ errorMessage }</span>
	</c:if>
</body>
</html>