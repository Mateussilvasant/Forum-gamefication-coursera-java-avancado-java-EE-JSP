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
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="bodyIndex">

	<c:import url="menuBar.jsp"></c:import>

	<div class="container-fluid">
		<h3>
			<b>Fórum Web</b> - Tópicos
		</h3>
		<hr></hr>

	</div>

	<div class="subBackground">

		<div class="container-fluid mb-4">

			<c:if test="${not empty param.exibirResult}">

				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Erro - </strong>Não foi possível exibir o tópico.
					${param.comentarioResult}
				</div>

			</c:if>

			<form action="ExibirTopico" method="POST" id="formExibirTopico">

				<c:if test="${not empty param.topicosResult}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>Erro - </strong>Não foi possível trazer a lista de
						tópicos... ${param.topicosResult}
					</div>
				</c:if>

				<c:choose>
					<c:when test="${not empty listaTopicos}">

						<c:forEach var="topico" items="${listaTopicos}">
							<div class="p-2"></div>
							<div class="card">
								<div class="card-header">
									<div class="tituloCriador">
										Criador por <b>${topico.nomeCriador}</b>
									</div>
								</div>
								<div class="card-body">
									<h5 class="card-title">
										<a class="tituloTopico"
											href="ExibirTopico?topicoID=${topico.numeroTopico}">${topico.titulo}</a>
									</h5>
									<p class="card-text">${topico.conteudoResumido}</p>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="d-flex justify-content-center alert alert-dark"
							role="alert">Sem tópicos para mostrar...</div>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div>

	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>