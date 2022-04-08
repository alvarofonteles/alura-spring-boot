<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page
	import="java.util.List ,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas JSP</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<a href="entrada?acao=NovaEmpresaForm">Cadastro Empresa</a>
	<br />
	
	<br /> Usuario Logado: ${usuarioLogado.login}
	<br />
	<br /> Lista Empresa Nova
	<br />
	<c:if test="${not empty nomeEmpresa}">
	 	Empresa ${nomeEmpresa}, Cadastrada com Sucesso (JSP)! <br />
	 	Data Abertura - <fmt:formatDate value="${dataAbertura}" type="date"
			pattern="dd/MM/yyyy" />!
    </c:if>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}-<fmt:formatDate
					value="${empresa.dataAbertura}" type="date" pattern="dd/MM/yyyy" />
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Edita</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remove</a>

			</li>
		</c:forEach>
	</ul>
</body>
</html>