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

	<form action="ExibirTopico" method="POST" id="formExibirTopico">
		<table>
			<c:forEach var="topico" items="${listaTopicos}">
				<tr>
					<td>${topico.titulo}</td>
					<td>${topico.nomeCriador}</td>
					<td><a href="ExibirTopico?topicoID=${topico.numeroTopico}">Exibir</a></td>
				</tr>
			</c:forEach>

		</table>
	</form>

</body>
</html>