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
		<% if(session.getAttribute("usuarioLogado")!=null) %>
		<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
		<c:if test="${tipo == 'D'}">
   		<a href="/javaliproject/remover/${disciplina.id }">remover</a>
   		
		</c:if>
		<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
		<c:if test="${tipo == 'A'}">
   		<a href="/javaliproject/aluno/adicionarDisciplinaAluno/${disciplina.id}">Inscrever-se</a>
   		
		</c:if>
		
		
		<br>
	</c:forEach>
	
	<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
		<c:if test="${tipo == 'P' || tipo=='D'}">
		<a href="/javaliproject/adicionar">Adicionar</a>   		
		</c:if>
	

</body>
</html>