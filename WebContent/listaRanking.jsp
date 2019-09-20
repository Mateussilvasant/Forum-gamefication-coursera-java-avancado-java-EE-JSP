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
<title>Ranking - Fórum</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<table class="table">

			<thead class="thead-dark">
				<tr>
					<th scope="col">Posição</th>
					<th scope="col">Nome usuário</th>
					<th scope="col">Login</th>
					<th scope="col">Pontos</th>
				</tr>
			</thead>


			<tbody>
				<c:forEach var="usuario" items="${listaRanking}">
					<tr>
						<td>${usuario.colocao}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.login}</td>
						<td>${usuario.pontos}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

		<div class="d-flex justify-content-end">
			<a class="btn btn-primary" href="ListarTopicos">Tópicos</a>
		</div>
	</div>


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>