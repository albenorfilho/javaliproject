<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Professores</title>
</head>
<body>
	<h2>Professores</h2>
	<c:forEach items="${professores}" var="professor">
		<label>Nome: ${professor.nome }</label> | 
		<label>Siape: ${professor.siape }</label> | 
		
		<a href="/javaliproject/professor/remover/${professor.id }">remover</a><br>
	</c:forEach>
	<a href="/javaliproject/professor/adicionar">Adicionar</a>
</body>
</html>