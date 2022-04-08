<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page
	import="java.util.List , br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/formNovaEmpresa.jsp" var="linkFormNovaEmpresa" />
<c:url value="/removeEmpresa" var="linkRemoveEmpresa" />
<c:url value="/mostraEmpresa" var="linkMostraEmpresa" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas JSP</title>
</head>
<body>
	<c:if test="${not empty nomeEmpresa}">
	 	Empresa ${nomeEmpresa}, Cadastrada com Sucesso (JSP)! <br />
	 	Data Abertura - <fmt:formatDate value="${dataAbertura}" type="date"
			pattern="dd/MM/yyyy" />!
    </c:if>
	<br /> Lista Empresa Nova
	<br />
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}-<fmt:formatDate
					value="${empresa.dataAbertura}" type="date" pattern="dd/MM/yyyy" />
				<a href="${linkMostraEmpresa}?id=${empresa.id}"> editar - </a> <a
				href="/gerenciador/removeEmpresa?id=${empresa.id}"> remover </a>

			</li>
		</c:forEach>
	</ul>
</body>
</html>