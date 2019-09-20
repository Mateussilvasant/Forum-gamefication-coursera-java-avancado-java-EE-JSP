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
<title>Login - Fórum</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body class="bodyCenter">


	<div class="formLogin">

		<form method="POST" action="FazerLogin">

			<div class="form-group">

				<div class="text-center">
					<h3>Entre no Fórum</h3>
				</div>


				<div class="form-group">
					<label for="login">Login</label> <input class="form-control"
						type="text" name="login" required
						placeholder="Informe o seu login" />
				</div>

				<div class="form-group">
					<label for="senha">Senha</label> <input class="form-control"
						type="password" name="senha" required
						placeholder="Informe sua senha">
				</div>

				<div class="d-flex justify-content-center form-group">
					<div class="p-2">
						<button type="submit" class="btn  btn-primary btn-lg ">Login</button>
					</div>
				</div>

				<div class="text-center">
					<p>
						Não tem acesso ao fórum? <a href="cadastrarUsuario.jsp">Cadastrar-se</a>
					</p>
				</div>

			</div>

		</form>


		<c:if test="${not empty erro}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>Erro Login </strong>${erro}
			</div>
		</c:if>


	</div>

	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>