<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	<c:if test="${not empty nomeEmpresa}">
	 	Empresa ${nomeEmpresa}, Cadastrada com Sucesso (JSP)! <br />
	 	Data Abertura - <fmt:formatDate value="${dataAbertura}" type="date"
			pattern="dd/MM/yyyy" />!
    </c:if>

	<c:if test="${empty nomeEmpresa}">
		Empresa	não Cadastrada!
    </c:if>
</body>
</html>