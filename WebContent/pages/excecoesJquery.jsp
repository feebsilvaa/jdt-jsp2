<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Capturando exceções com Jquery</title>
<script type="text/javascript" src="../resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>Capturando exceções com Jquery</h1>
	<input type="text" name="teste" id="teste_jquery" value="0">
	<button onclick="testarExcecao();">testarExcecao</button>
	
	<script type="text/javascript">
		function testarExcecao() {
			let campo = $('#teste_jquery');			
			$.ajax({
				method: "POST",
				url: "/jdt-jsp2/testarExcecaoJquery",
				data: { valorParam: campo.val() }
			}).done(function (res) {
				console.log(res);
				alert(res);
			}).fail(function (res) {
				console.log(res);
				alert(res.responseText);
				campo.focus();
			})
		}
	</script>
</body>
</html>