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
			<h1>Inserir nova participacao para o filme: ${item.filme.titulo}</h1>
		</div>

		<form method="post" name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/participacao/inserir">

			<!-- Importante! Nao esqueca de repassar o codigo do filme -->
			<input type="hidden" name="codFilme" value="${item.filme.codFilme}" />

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<ul>
						<c:forEach items="${erros}" var="msg">
							<li class="erro">${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="personagem">Nome
					do personagem:</label>
				<div class="col-sm-5">
					<input type="text" name="personagem" id="personagem"
						value="${item.personagem}" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="artista">Selecione
					o artista:</label>
				<div class="col-sm-5">
					<select name="codArtista" class="form-control">
						<option value="">-- Selecione o artista--</option>
						<c:forEach items="${artistas}" var="x">
							<option value="${x.codArtista}" <c:if test="${x == artistaSelecionado}">selected="selected"</c:if>>
								${x.nome}, <fmt:setLocale value="pt_BR" /><fmt:formatNumber type="currency" value="${x.cache}" />    
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="desconto">Desconto
					no cache:</label>
				<div class="col-sm-5">
					<input type="text" name="desconto" id="desconto"
						value="${item.desconto}" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/participacao/filmes"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
