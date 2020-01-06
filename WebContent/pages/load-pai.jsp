<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Load JQuery</title>
<script type="text/javascript" src="../resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>Página Pai</h1>
	<jsp:include page="menu-pages.jsp" />
	
	<button onclick="carregarPaginaFilha();">Carregar Página Filha</button>	
	<div id="pagina_carregada"></div>
	
	<script type="text/javascript">
		function carregarPaginaFilha() {
			$("#pagina_carregada").load("load-filha.jsp");
		}
	</script>
</body>
</html>