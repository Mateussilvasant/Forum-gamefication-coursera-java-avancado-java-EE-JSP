<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Login - Fórum</title>
<link href="css/loginStyle.css" rel="stylesheet">
</head>
<body>

	<div class="containerMensagem">S
		<h1>${erro}</h1>
	</div>

	<form method="POST" action="FazerLogin" id="form">
		<div class="loginContainer">
			<label for="login"><b>Login</b></label> <input type="text"
				name="login" required placeholder="Informe o seu login" /> <label
				for="senha"><b>Senha</b></label> <input type="password" name="senha"
				required placeholder="Informe sua senha">

			<button type="submit">Entrar</button>

		</div>
	</form>
	<button onclick="location.href='cadastrarUsuario.html'">Cadastrar</button>
</body>
</html>