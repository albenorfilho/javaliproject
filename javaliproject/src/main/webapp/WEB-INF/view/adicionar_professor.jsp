<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Professores</title>
</head>
<body>
	<h2>Novo Professor</h2><br>
	
	<form:form id="adicionarProfessorForm" commandName="professor" servletRelativeAction="/professor/adicionar" method="POST">
		<label>Nome: </label>
		<form:input type="text" path="nome"/><br>
		<label>SIAPE: </label>
		<form:input type="text" path="siape"/><br>
		
		
		<input type="submit" value="Adicionar"/>
	</form:form>
</body>
</html>