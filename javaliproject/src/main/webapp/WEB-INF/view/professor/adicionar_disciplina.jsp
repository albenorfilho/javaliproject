<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Disciplinas</title>
</head>
<body>
	<h2>Nova disciplina</h2><br>
	
	<form:form id="adicionarDisciplinaForm" commandName="disciplina" servletRelativeAction="/professor/adicionarDisciplina" method="POST">
		<label>Nome: </label>
		<form:input type="text" path="nome"/><br>
		<label>Descrição: </label>
		<form:input type="text" path="descricao"/><br>
		
		<input type="submit" value="Adicionar"/>
	</form:form>
</body>
</html>