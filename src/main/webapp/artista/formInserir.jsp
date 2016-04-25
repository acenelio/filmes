<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<h1>Inserir novo Artista</h1>
		</div>

		<form name="myform" class="form-horizontal" 
			action="<%=request.getContextPath()%>/artista/inserir">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome:</label>	
				<div class="col-sm-5">
					<input type="text" name="nome" id="nome" value="${item.nome}" 
					required="required" class="form-control"/>	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nacionalidade">Nacionalidade:</label>	
				<div class="col-sm-5">
					<input type="text" name="nacionalidade" id="nacionalidade" value="${item.nacionalidade}" 
					required="required" class="form-control"/>	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="cache">Cache:</label>	
				<div class="col-sm-5">
					<input type="text" name="cache" id="cache" value="${item.cache}" 
					required="required" class="form-control"/>	
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nascimento">Nascimento:</label>	
				<div class="col-sm-5">
					<input type="text" name="nascimento" id="nascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${item.nascimento}"/>"  
					required="required" class="form-control"/>	
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">	
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/artista/listar" 
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
