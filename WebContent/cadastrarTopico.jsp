<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Novo Tópico - Fórum</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body class="bodyCenter">

	<div class="container">
		<form method="POST" action="CadastrarTopico">

			<h2>Novo Tópico</h2>
			<hr></hr>

			<div class="form-group">

				<label for="idTitulo">Título</label> <input maxlength="100" class="form-control"
					id="idTitulo" type="text" placeholder="Informe um título"
					name="titulo" required>

			</div>

			<div class="form-group">
				<label for="areaConteudo">Conteúdo</label>
				<textarea class="form-control" id="areaConteudo" required
					maxlength="1000" name="textTopico"></textarea>
			</div>

			<div class="d-flex justify-content-center form-group">
				<div class="p-4">
					<button class="btn btn-primary" type="submit">Enviar
						Tópico</button>
				</div>
			</div>
		</form>

	</div>


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>