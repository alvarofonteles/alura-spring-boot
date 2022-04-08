<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Empresas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	<!--method="post"-->
	<form action="${linkEntradaServlet }" method="post">
		Nome: <input type="text" name="nomeEmpresa" /> <br /> Data Abertura:
		<input type="text" name=dataAbertura /> <input type="submit" /> <input
			type="hidden" name="acao" value="NovaEmpresa" />
	</form>
</body>
</html>