<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuarios</title>
</head>
<body>
	<h2>Professores</h2>
	<c:forEach items="${usuarios}" var="usuario">
		<c:if test="${usuario.tipo=='P'}">
	    <label>Nome: ${usuario.nome }</label> | 
		<label>Username: ${usuario.username }</label> | 
		<label>Id: ${usuario.id }</label> |		
		
		
		
		<a href="/javaliproject/usuario/remover/${usuario.id }">remover</a><br>    
	        
	    	
	    </c:if>
		
	</c:forEach>
	<a href="/javaliproject/professor/adicionar">Adicionar</a>
	
	<h2>Alunos</h2>	
	
	<c:forEach items="${usuarios}" var="usuario">
		<c:if test="${usuario.tipo=='A'}">
	    <label>Nome: ${usuario.nome }</label> | 
		<label>Username: ${usuario.username }</label> | 
		<label>Id: ${usuario.id }</label> |		
		
		
		
		<a href="/javaliproject/usuario/remover/${usuario.id }">remover</a><br>    
	        
	    	
	    </c:if>
		
	</c:forEach>
	<a href="/javaliproject/aluno/adicionar">Adicionar</a>
	
</body>
</html>