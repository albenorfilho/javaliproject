<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h2>Novo Item</h2><br>
	
	<form:form id="adicionarItemForm" commandName="item" servletRelativeAction="/atividade/adicionarItem" method="POST">
		<label>Título: </label>
		<form:input type="text" path="titulo"/><br>
		<label>Descrição: </label>
		<form:input type="text" path="descricao"/><br>
		<label>Pontuação para este item: </label>
		<form:input type="number" path="pontuacao"/><br>
		<label>Caso de Teste: </label>
		<input type="file" id="myfile" name="javafile"/><br>
		
		<input type="submit" value="Adicionar"/>
	</form:form>
</body>
</html>