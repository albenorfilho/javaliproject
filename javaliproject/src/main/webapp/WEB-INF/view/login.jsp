<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and magnified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<title>Login</title>
</head>

<body>
	<div id="wrap">
		<div class="login-container" align="center">
			<div class="login-form">				
				<nav class="navbar navbar-default">
				  <div class="container-fluid">
				    <div class="navbar-header">
				       <img alt="Brand" class="logo" src="resources/img/logo3.PNG">
					</div>
					<form:form id="loginForm" class="nav navbar-form navbar-right" commandName="usuario" servletRelativeAction="/login" method="POST">
						<div class="form-group">
							<i class="glyphicon glyphicon-user"></i>
							<form:input  class="form-control" type="text" path="username" placeHolder="Usuario"/>
							<i class="glyphicon glyphicon-lock"></i>
							<form:input  class="form-control" type="password" path="senha" placeHolder="Senha"/>
						</div>
						<input type="submit" class="btn btn-default" value="login"/>
					</form:form>
			
				  </div>
				</nav>
			</div>
		</div>
				
			<div class="login-info">
			
				<div class="login-text">
					<h1 class="text-center"><span id="title">Bem Vindo</span></h1>
				</div>
				<p>Esse é o ambiente JAvali. Um ambiente onde professores e alunos de programação podem intensificar práticas de programação. Esse ambiente executa um mecanismo de avaliação baseado em casos de teste que são desenvolvidos pelos professores. Assim, alunos poderão ter um rápido feedback sobre seus trabalhos e o professor não precisará gastar muito tempo para corrigir todos os trabalhos. Use o ambiente Javali!</p>	
				<h2 class="text-center">		
			  		<p><a class="btn btn-primary btn-lg" href="/javaliproject/aluno/adicionar">
			  			Inscrever-se
			  		</a>
			  	  </p>
			  	</h2>
			</div>
		</div>
	
	<div id="footer">
      <div class="container">
        <p class="text-muted credit">Universidade Federal do Ceará - Campus Quixadá.</p>
      </div>
    </div>

</body>
</html>