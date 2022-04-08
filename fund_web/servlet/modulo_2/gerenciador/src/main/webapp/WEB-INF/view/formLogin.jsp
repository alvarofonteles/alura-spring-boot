<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	Acesso Padrao - Login: admin / Senha: admin.
	<br />
	<br />
	<form action="${linkEntradaServlet}" method="post">
		Login: <input type="text" name="login" /> <br> Senha: <input
			type="password" name="senha" /> <input type="submit" /> <input
			type="hidden" name="acao" value="Login" />
	</form>
</body>
</html>