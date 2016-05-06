<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Filmes</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes do filme</h1>
		</div>

		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codFilme}</li>
				<li class="list-group-item">Título: ${item.titulo}</li>
				<li class="list-group-item">Duração: ${item.duracao}</li>
				<li class="list-group-item">Ano: ${item.ano}</li>
				<li class="list-group-item">Gasto total em cache: <fmt:setLocale value="pt_BR" /> <fmt:formatNumber
						type="currency" value="${item.cacheTotal}" /></li>
			</ul>
		</div>
	</div>

	<div class="container">
		<div class="page-header">
			<h2>Participações</h2>
		</div>

		<div>
			<table class="table">
			<thead>
				<tr>
					<th>Artista</th>
					<th>Personagem</th>
					<th>Cache do artista</th>
					<th>Desconto</th>
					<th>Cache pago</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${item.participacoes}" var="x">
					<tr>
						<td>${x.artista.nome}</td>
						<td>${x.personagem}</td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.artista.cache}" /></td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.desconto}" /></td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.cachePago}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
