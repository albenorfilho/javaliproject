<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and magnified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
	<title>Cadastro</title>
</head>
<body>
<div id="wrap">
		
		<div class="login-container" align="center">
			<div class="login-form">				
				<nav class="navbar navbar-default">
				  <div class="container-fluid">
				    <div class="navbar-header">
				       <img alt="Brand" class="logo" src="../resources/img/logo3.PNG">
					</div>
				  </div>
				</nav>
			</div>
		</div>

	
	
	<form:form id="adicionarAlunoForm"  class="form-center" commandName="aluno" servletRelativeAction="/aluno/adicionar" method="POST">
		
		<div class="form-group">
			<h2>Novo Aluno</h2><br>
			<label for="name">Nome: </label><br>
			<form:input id="name" type="text" path="nome" class="form-control" placeholder="Nome"/><br>    
			<label>Username: </label><br>
			<form:input type="text" path="username" class="form-control" placeholder="Username"/><br>
			<label>Senha: </label><br>
			<form:input type="password" path="senha" class="form-control" placeholder="Senha"/><br>
			<label>Matricula: </label><br>
			<form:input type="text" path="matricula" class="form-control" placeholder="Matrícula"/><br>
		<input type="submit" value="Adicionar" class="btn btn-default"/>
		</div>
		
	</form:form>
	</div>
	
	<div id="footer">
      <div class="container">
        <p class="text-muted credit">Universidade Federal do Ceará - Campus Quixadá.</p>
      </div>
    </div>	
</body>
</html>