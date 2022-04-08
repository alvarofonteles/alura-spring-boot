<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Empresas</title>
</head>
<body>

	<!--method="post"-->
	<form action="${linkServletAlteraEmpresa }" method="post">
		Códigos: <input type="hidden" name="id" value="${empresa.id}" /> Nome:
		<input type="text" name="nomeEmpresa" value="${empresa.nome}" /><br />
		Data Abertura: <input type="text" name="dataAbertura"
			value="<fmt:formatDate value="${empresa.dataAbertura}" type="date" pattern="dd/MM/yyyy"/>" />

		<input type="submit" />
	</form>
</body>
</html>