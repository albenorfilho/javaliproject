<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and magnified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Disciplinas</title>
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
				  </div>
				</nav>
			</div>
		</div>
		
		<div class="row content">
	    <div class="col-sm-3 sidenav menu-left">
		  <ul class="nav nav-pills nav-stacked">
	        <% if(session.getAttribute("usuarioLogado")!=null) %>
						<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
						<c:if test="${tipo=='P'}">
		    				<li><a href="/javaliproject/professor/indexP">Home</a></li>
		    			</c:if>
		    			<c:if test="${tipo=='A'}">
		    				<li><a href="/javaliproject/aluno/indexA">Home</a></li>
		    			</c:if>
	        <li class="active"><a href="/javaliproject/listar">Ver todas as disciplinas</a></li>
	        <li><a href="/javaliproject/logout">Sair do sistema</a></li>
	      </ul>
	    </div>
	    <div class="col-sm-9 content-right">
	    	<h2>Disciplinas</h2>
	    	<table class="table table-hover table-striped">
	    		<thead>
	    		<tr>
	    			<th>Nome</th>
	    			<th>Descrição</th>
	    			<th>Professor</th>
	    			<th>Ações</th>
	    		</tr>
	    		</thead>
	    		<tbody>
				<c:forEach items="${disciplinas}" var="disciplina">
					<tr>
					<td><label>${disciplina.nome }</label></td>
					<td><label>${disciplina.descricao }</label> </td>
					<td><label>${disciplina.professor.nome }</label> </td>
					<% if(session.getAttribute("usuarioLogado")!=null) %>
					<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
					<c:if test="${tipo == 'D'}">
			   		<td><a href="/javaliproject/remover/${disciplina.id }">remover</a></td>
			   		
					</c:if>
					<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
					<c:if test="${tipo == 'A'}">
			   		<td><a href="/javaliproject/aluno/adicionarDisciplinaAluno/${disciplina.id}">Inscrever-se</a></td>
	
					</c:if>
					</tr>
				</c:forEach>
				</tbody>
				</table>
		
		<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
			<c:if test="${tipo == 'P' || tipo=='D'}">
			<a href="/javaliproject/adicionar">Adicionar</a>   		
		</c:if>
	  	</div>
	
	</div>
	<div id="footer">
      <div class="container">
        <p class="text-muted credit">Universidade Federal do Ceará - Campus Quixadá.</p>
      </div>
    </div>
</body>
</html>