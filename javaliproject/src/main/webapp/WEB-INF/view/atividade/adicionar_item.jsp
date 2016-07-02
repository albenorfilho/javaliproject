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
	
	<form:form id="adicionarItemForm" enctype="multipart/form-data" commandName="item" servletRelativeAction="/atividade/adicionarItem" method="POST">
		<label>Título: </label>
		<form:input type="text" path="titulo"/><br>
		<label>Descrição: </label>
		<form:input type="text" path="descricao"/><br>
		<label>Peso para este item: </label>
		<form:input type="number" path="pontuacao"/><br>
		<label>Projeto de caso de teste: </label>
		<input type="file" id="myfile" name="javafile" /><br>
		<label>Nome do Teste 1: </label>
		<form:input type="text" id="nome_teste1" path="associacoes[0].testeNome" /><br>
		<label>Nome da implementacao 1: </label>
		<form:input type="text" id="nome_impl1" path="associacoes[0].classeNome" /><br>
		<label>Nome do Teste 2: </label>
		<form:input type="text" id="nome_teste2" path="associacoes[1].testeNome" /><br>
		<label>Nome da implementacao 2: </label>
		<form:input type="text" id="nome_impl2" path="associacoes[1].classeNome" /><br>
		
		
			
		<input type="submit" value="Adicionar"/>
	</form:form>
	
	
	
	
</body>
</html>