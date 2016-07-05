
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
 <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and magnified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Atividade</title>
 </head>
 <body>
 
 
 <div id="wrap">
		<div class="login-container" align="center">
			<div class="login-form">				
				<nav class="navbar navbar-default">
				  <div class="container-fluid">
				    <div class="navbar-header">
				       <img alt="Brand" class="logo" src="../../resources/img/logo3.PNG">
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
			        <li><a href="/javaliproject/listar">Ver todas as disciplinas</a></li>
			        <li><a href="../../logout">Sair do sistema</a></li>
			      </ul>
		    </div>
		    <div class="col-sm-9 content-right">
			    <h1>${atividade.titulo }</h1>

				<label>Descrição: ${atividade.descricao }</label>
				
				
				<h2>Itens</h2>
				<table class="table table-hover table-striped">
		    		<thead>
		    		<tr>
		    			<th>Titulo</th>
		    			<th>Ações</th>
		    			<% if(session.getAttribute("usuarioLogado")!=null) %>
						<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
						<c:if test="${tipo == 'D' || tipo=='P'}">
		    				<th>Remover</th>
		    			</c:if>
		    		</tr>
		    		</thead>
		    		<tbody>
					<c:forEach items="${itens}" var="item">
						<tr>
							<td><label>${item.titulo }</label></td>
							<% if(session.getAttribute("usuarioLogado")!=null) %>
							<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
							<c:if test="${tipo == 'A'}">
					  		<td><a href="/javaliproject/item/submissao/${item.idItem}">Adicionar Submissão</a><td>
					  		</c:if>
						</tr>		
					</c:forEach>
					</tbody>
					</table>
						<% if(session.getAttribute("usuarioLogado")!=null) %>
						<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
						<c:if test="${tipo == 'D' || tipo=='P'}">
				   		<a href="/javaliproject/atividade/adicionarItem/${atividade.idAtividade}">Adicionar</a>
				  		</c:if>
	    	</div>
  		</div>
 
	
	</div>
 
 
 
 </div>
		<div id="footer">
      <div class="container">
        <p class="text-muted credit">Universidade Federal do Ceará - Campus Quixadá.</p>
      </div>
    </div>	
 
 
 	<!-- 
	<form:form id="adicionarSubmissaoItemForm" enctype="multipart/form-data" commandName="item" servletRelativeAction="/atividade/adicionarSubmissaoItem" method="POST">
		<label>Arquivo java: </label>
		<input type="file" id="myfile" name="javafile" /><br>
		
		<input type="submit" value="Adicionar"/>
	</form:form>

 -->
 </body>
 </html>