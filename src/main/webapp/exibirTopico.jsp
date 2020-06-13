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
<title>Tópico - ${topico.titulo}</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body class="bodyIndex">
	<c:import url="menuBar.jsp"></c:import>

	<div class="subBackground">
		<div class="container-fluid">
			<form action="CadastrarComentario" method="POST">

				<div class="cardTopico card mb-5 ">

					<div class="card-body">

						<h5 class="d-flex justify-content-center card-title">${topico.titulo}</h5>
						<h6 class="card-subtitle mb-3">
							<i> Tópico criado por ${topico.nomeCriador}</i>
						</h6>
						<p class="card-text">${topico.conteudo}</p>
					</div>
				</div>

				<div class="form-group">
					<input type="hidden" name="idTopico" value="${topico.numeroTopico}" />
					<label for="idTextArea"><b>Faça um comentário sobre o
							que você acha abaixo:</b></label>
					<textarea id="idTextArea" class="form-control" required
						name="textoComentario"></textarea>
				</div>

				<div class="form-group mb-3">
					<button class="btn btn-primary" type="submit">Comentar</button>
				</div>

				<c:if test="${not empty param.comentarioResult}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>Erro - </strong>Não foi possível realizar comentário.
						${param.comentarioResult}
					</div>
				</c:if>

				<table class="table">
					<c:forEach var="comentario" items="${topico.comentarios}">
						<tr>
							<td><div class="itemComentario">
									<b>${comentario.nomeCriador}</b>
									<p>${comentario.conteudo}</p>
								</div></td>
						</tr>
					</c:forEach>
				</table>


			</form>
		</div>
	</div>

	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>