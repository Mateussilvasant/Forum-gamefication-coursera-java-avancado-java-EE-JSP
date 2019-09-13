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

	<div class="containerRanking">

		<table>

			<c:forEach var="usuario" items="${listaRanking}">
				<tr>
					<td>${usuario.colocao}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.pontos}</td>
				</tr>

			</c:forEach>

		</table>


		<a href="ListarTopicos">Tópicos</a>
	</div>
</body>
</html>