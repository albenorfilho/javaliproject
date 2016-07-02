<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>

<body>

	<div class="login-container" align="center">
		<div class="login-form">
			
			<div class="login-text">
				<span id="title">Login</span>
			</div>
	
				
					<div class="form-group">
						<div id="inputLogin" class="form-inline input-group input-login">
						    <span class="input-group-addon"><i class="fa fa-user"></i></span>
							<form:form id="loginForm" commandName="usuario" servletRelativeAction="/login" method="POST">
								<label>Username: </label>
								<form:input type="text" path="username"/><br>
								<label>Senha: </label>
								<form:input type="password" path="senha"/><br>
								
								
								<input type="submit" value="login"/>
							</form:form>
						</div>
					</div>
		  	<a href="/javaliproject/aluno/adicionar">Inscrever-se</a><br>
		</div>
	</div>






</body>
</html>