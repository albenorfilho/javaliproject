<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADMINs</title>
</head>
<body>
	<h2>Novo Admin</h2><br>
	
	<form:form id="adicionarAdministratorForm" commandName="administrator" servletRelativeAction="/administrator/adicionar" method="POST">
		<label>Admin: </label>
		<form:input type="text" path="admin"/><br>
		<label>Username: </label>
		<form:input type="text" path="username"/><br>
		<label>Senha: </label>
		<form:input type="password" path="senha"/><br>
		
		
		<input type="submit" value="Adicionar"/>
	</form:form>
</body>
</html>