<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Alunos</title>
</head>
<body>
	<h2>Alunos</h2>
	<c:forEach items="${alunos}" var="aluno">
		<label>Nome: ${aluno.nome }</label> | 
		<label>Matricula: ${aluno.matricula }</label> | 
		
		<a href="/javaliproject/aluno/remover/${aluno.id }">remover</a><br>
	</c:forEach>
	<a href="/javaliproject/aluno/adicionar">Adicionar</a>
</body>
</html>