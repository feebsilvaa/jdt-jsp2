<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload de imagens</title>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>
	<h1>Upload de Imagens</h1>
	<jsp:include page="menu-pages.jsp" />
	
	<input type="file" id="upload" name="upload" onchange="loadImage();">
	<br>
	<img alt="Imagem" src="" id="target" width="200" height="200">


	<script type="text/javascript">
		
		function loadImage() {
			
			let target = document.querySelector("img");
			let input = document.querySelector("input[type=file]").files[0];
			
			let reader = new FileReader();
			reader.onloadend = function() {
				target.src = reader.result;
			}
			
			if (input) {
				reader.readAsDataURL(input);
			} else {
				target.src = "";
			}
		}
		
	</script>
</body>
</html>


