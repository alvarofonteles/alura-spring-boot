<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novoLogin" var="linkServletNovoLogin" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Senha</title>
</head>
<body>
	<!--method="post"-->
	<form action="${linkServletNovoLogin}" method="post">
		Login: <input type="text" name="login" /> <br> Senha: <input
			type="password" name="senha" /><input type="submit" />
	</form>
</body>
</html>