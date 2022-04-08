<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresas</title>
</head>
<body>

	<!--method="post"-->
	<form action="${linkServletNovaEmpresa }" method="post">
		Nome: <input type="text" name="nomeEmpresa" /> <br />
		Data Abertura: <input type="text" name=dataAbertura /> <input type="submit" />
	</form>
</body>
</html>