
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
 <head>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and magnified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Professor</title>
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
		
	  <div class="row content">
	    <div class="col-sm-3 sidenav menu-left">
		  <ul class="nav nav-pills nav-stacked">
	        <li class="active"><a href="indexP">Home</a></li>
	        <li><a href="/javaliproject/listar">Ver todas as disciplinas</a></li>
	        <li><a href="../logout">Sair do sistema</a></li>
	      </ul>
	    </div>
	    <div class="col-sm-9 content-right">
	    	<h1 text-center>Bem vindo, ${usuarioLogado.nome}!</h1>
			<h2>Minhas Disciplinas</h2>
	    	<table class="table table-hover table-striped">
	    		<thead>
	    		<tr>
	    			<th>Nome</th>
	    			<th>Descrição</th>
	    			<th>Ações</th>
	    		</tr>
	    		</thead>
	    		<tbody>		
	    		<c:forEach items="${disciplinas}" var="disciplina">
					<tr>
						<td>${disciplina.nome }</td>
						<td>${disciplina.descricao }</label></td>
						<td><a href="/javaliproject/disciplina/index/${disciplina.id }">Entrar</a></td> 
				<td><a href="/javaliproject/professor/removerDisciplina/${disciplina.id }">remover |</a><td>
	
	
				
					</tr>
				</c:forEach>
				</tbody>
			</table>
		<a href="/javaliproject/professor/adicionarDisciplina">Adicionar</a>
	    </div>
	  </div>
			
		
	</div>
		<div id="footer">
      <div class="container">
        <p class="text-muted credit">Universidade Federal do Ceará - Campus Quixadá.</p>
      </div>
    </div>	


 </body>
 </html>