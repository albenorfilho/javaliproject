<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Disciplinas</title>
</head>
<body>
	<h2>Disciplinas</h2>
	<c:forEach items="${disciplinas}" var="disciplina">
		<label>Nome: ${disciplina.nome }</label> | 
		<label>Email: ${disciplina.descricao }</label> | 
		
		<a href="/javaliproject/remover/${disciplina.id }">remover</a><br>
	</c:forEach>
	<a href="/javaliproject/adicionar">Adicionar</a>
</body>
</html>