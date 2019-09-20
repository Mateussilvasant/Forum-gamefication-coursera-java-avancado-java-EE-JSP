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
<title>Início - Fórum</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="ListarTopicos">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Alterna navegação">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="ListarRanking">Ranking</a></li>
				<li class="nav-item"><a class="nav-link"
					href="cadastrarTopico.jsp">Inserir Tópico</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">

		<form action="ExibirTopico" method="POST" id="formExibirTopico">
			<table class="table">
				<c:forEach var="topico" items="${listaTopicos}">
					<tr>
						<td>
							<div class="card">
								<div class="card-header">
									Criador por <b>${topico.nomeCriador}</b>
								</div>
								<div class="card-body">
									<h5 class="card-title">${topico.titulo}</h5>
									<p class="card-text">${topico.getConteudoResumido()}</p>
									<a class="btn btn-primary"
										href="ExibirTopico?topicoID=${topico.numeroTopico}">Exibir</a>
								</div>

							</div>

						</td>
					</tr>
				</c:forEach>

			</table>
		</form>


	</div>

	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>