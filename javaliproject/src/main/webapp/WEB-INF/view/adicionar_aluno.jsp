<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Alunos</title>
</head>
<body>
	<h2>Novo Aluno</h2><br>
	
	<form:form id="adicionarAlunoForm" commandName="aluno" servletRelativeAction="/aluno/adicionar" method="POST">
		<label>Nome: </label>
		<form:input type="text" path="nome"/><br>
		<label>Username: </label>
		<form:input type="text" path="username"/><br>
		<label>Senha: </label>
		<form:input type="password" path="senha"/><br>
		<label>Matricula: </label>
		<form:input type="text" path="matricula"/><br>
		
		
		
		<input type="submit" value="Adicionar"/>
	</form:form>
</body>
</html>