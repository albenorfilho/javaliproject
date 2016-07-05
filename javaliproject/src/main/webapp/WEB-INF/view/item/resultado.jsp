
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
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>RESULTADO</title>
 </head>
 <body>
 <%Thread.sleep(2000);%>	
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

 <div class="container" align="center">
		<img src="../resources/img/boar.jpg" width="100" height="115">
		<h2>RESULTADO:</h2>

	<div class="progress">
  		<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: ${resultado.nota * 10}%">
  	 	</div>
	</div> 
    <h2>Sua nota é ${resultado.nota}</h2>
	<c:set var="nota" scope="session" value="${resultado.nota}"/>
						<c:if test="${nota==10}">
		    				<label style="color: green">${resultado.mensagem}</label><br/>
		    			</c:if>
		    			<c:if test="${nota<10}">
		    				<label style="color: red">${resultado.mensagem}</label><br/>
		    			</c:if>
	
	<input type="button" value="Voltar" class="btn btn-primary" onclick="window.location.href='/javaliproject/aluno/indexA'"/>
	
	</div>
	
    

 
 </div>

<div id="footer">
      <div class="container">
        <p class="text-muted credit">Universidade Federal do Ceará - Campus Quixadá.</p>
      </div>
    </div>	


 </body>
 </html>