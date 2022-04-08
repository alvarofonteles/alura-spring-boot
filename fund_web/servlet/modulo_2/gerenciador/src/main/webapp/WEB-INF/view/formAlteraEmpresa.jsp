<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Empresas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	
	<!--method="post"-->
	<form action="${linkEntradaServlet }" method="post">
		<input type="hidden" name="id" value="${empresa.id}" /> <input
			type="hidden" name="acao" value="AlteraEmpresa" /> Nome: <input
			type="text" name="nomeEmpresa" value="${empresa.nome}" /><br />
		Data Abertura: <input type="text" name="dataAbertura"
			value="<fmt:formatDate value="${empresa.dataAbertura}" type="date" pattern="dd/MM/yyyy"/>" />

		<input type="submit" />
	</form>
</body>
</html>