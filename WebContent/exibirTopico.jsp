<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Principal - Fórum</title>
<link href="css/styleApp.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="containerTitle">
			<h1>${topico.titulo}</h1>
			<p>
				criador por <b>${topico.nomeCriador}</b>
			<p>${topico.conteudo}</p>
		</div>

		<table>
			<c:forEach var="comentario" items="${topico.comentarios}">
				<tr>
					<td><div class="itemComentario">
							<b>${comentario.nomeCriador}</b>
							<p>${comentario.conteudo}</p>
						</div></td>
				</tr>
			</c:forEach>
		</table>

		<div class="container">
			<form action="CadastrarComentario" method="POST">
				<input type="hidden" name="idTopico" value="${topico.numeroTopico}" />
				<textarea name="textoComentario"></textarea>
				<button type="submit">Comentar</button>
			</form>
		</div>

	</div>

	<div class="barraOpcoes">
		<a href="ListarTopicos">Tópicos</a>
	</div>

</body>
</html>