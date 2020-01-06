<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Progress Bar</title>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
.bar {
	width: 500px;
}

.background-bar {
	width: 100%;
	background-color: #ddd; /* fundo da barra de progresso */
}

.progress {
	width: 1%;
	height: 30px;
	background-color: #4CAF50;
}

.ui-progressbar {
	width: 500px;
	position: relative;
}

.progress-label {
	position: absolute;
	left: 50%;
	top: 4px;
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
  src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
  integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
  crossorigin="anonymous"></script>
</head>
<body>
	<h1>Progress Bar</h1>
	<jsp:include page="menu-pages.jsp" />

	<h3>Barra de progresso com javascript</h3>
	<button onclick="progressBar();">Iniciar progress bar</button>

	<br>
	<br>

	<div class="bar">
		<div class="background-bar">
			<div id="progress" class="progress"></div>
		</div>
	</div>

	<h3>Barra de progresso com JQuery</h3>
	<button onclick="progressBarJquery();">Iniciar progress bar</button>

	<br>
	<br>

	<div id="progressbar">
		<div class="progress-label"></div>
	</div>




	<script type="text/javascript">
		function progressBar() {
			var elem = document.getElementById("progress");
			var width = 0;
			var id = setInterval(frame, 10);

			function frame() {
				if (width >= 100) {
					clearInterval(id);
				} else {
					width++;
					elem.style.width = width + "%";
				}
			}
		}

		function progressBarJquery() {
			
			var progressbar = $("#progressbar"), progressLabel = $(".progress-label");
			var barInitializationDelay = 1000;

			let baseText = "Loading..."
			progressLabel.text(baseText);
			
			progressbar.progressbar({ // cria a barra no div
				value : false,
				change : function() {
					progressLabel.text(progressbar.progressbar("value") + "%");
				},
				complete : function() {
					progressLabel.text("Complete!");
				}
			});

			function progress() {
				var val = progressbar.progressbar("value") || 0;
				var barIncrementationValue = 1;
				var barIncrementationDelay = 50;
				
				progressbar.progressbar("value", val + barIncrementationValue);

				if (val < 99) {
					setTimeout(progress, barIncrementationDelay);
				}
			}

			setTimeout(progress, barInitializationDelay);
		}
	</script>
</body>
</html>


