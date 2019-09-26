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
<title>Novo Usuário - Fórum</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body class="bodyCenter">

	<div class="container">
		<form method="POST" action="CadastrarUsuario">
			<div class="text-center">
				<h2>
					<b>Cadastra-se no fórum, é rápido!</b>
				</h2>
			</div>


			<h5>Dados pessoais</h5>
			<hr></hr>

			<div class="form-row">

				<div class="col-lg-6  mb-3 px-3 ">
					<label for="idNome">Nome</label> <input class="form-control"
						id="idNome" type="text" placeholder="Informe seu nome" name="nome"
						required>
				</div>

				<div class="col-lg-6 mb-3 px-3">
					<label for="idEmail">Email</label> <input class="form-control"
						id="idEmail" type="email" name="email"
						placeholder="Informe seu email">
				</div>

			</div>

			<h5>Dados conta</h5>
			<hr></hr>

			<div class="form-row">
				<div class="col-lg-6 mb-3 px-3">
					<label for="idLogin">Login</label> <input class="form-control"
						id="idLogin" type="text" name="login" required
						placeholder="Informe um login" />
				</div>

				<div class="col-lg-6 mb-3 px-3">

					<label for="idPassword">Senha</label> <input class="form-control"
						id="idPassword" type="password" name="senha" required
						placeholder="Informe uma senha">
				</div>

			</div>

			<div class="d-flex justify-content-center form-group">
				<div class="p-4">
					<button class="btn btn-primary" type="submit">Cadastrar-se</button>
				</div>
			</div>

			<c:if test="${not empty param.cadastroResult}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Erro - </strong>Não foi possível cadastrar o Usuário.
					${param.cadastroResult}
				</div>
			</c:if>

		</form>
	</div>

	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>