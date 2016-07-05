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
	<link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
	<title>Adicionar Item</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
	
	<form:form id="adicionarItemForm" class="form-center" enctype="multipart/form-data" commandName="item" servletRelativeAction="/atividade/adicionarItem" method="POST">
		<div class="form-group">
		<h2>Novo Projeto</h2>
		<label>Título: </label>
		<form:input type="text" path="titulo"/><br>
		<label>Descrição: </label>
		<form:input type="text" path="descricao"/><br>
		<label>Projeto com os casos de teste: </label>
		<input type="file" id="myfile" name="javafile" /><br>
		
		
		<div class="input_fields_wrap">
		  <div>
		    <label>Digite o nome dos testes e em seguida o nome das implementações que serão testadas</label><br>
			<form:input type="text" id="nome_teste1" path="associacoes[0].testeNome" placeholder="Ex.: TesteNumero"/>
			<form:input  type="text" id="nome_impl1" path="associacoes[0].classeNome"   placeholder="Irá testar: NumeroImpl"/>
		  </div>
		  
		</div>
		<button class="add_field_button">Adicionar mais classes</button><br><br>
		
			
		<input type="submit" value="Adicionar"/>
		</div>
	</form:form>
		
				<script type="text/javascript">
				$(document).ready(function() {
					  var max_fields = 10; //maximum input boxes allowed
					  var wrapper = $(".input_fields_wrap"); //Fields wrapper
					  var add_button = $(".add_field_button"); //Add button ID
			
					  var x = 1; //initlal text box count
					  $(add_button).click(function(e) { //on add input button click
					    e.preventDefault();
					    var length = wrapper.find("input:text").length/2;
			
					    if (x < max_fields) { //max input box allowed
					      x++; //text box increment
					      $(wrapper).append('<div><input type="text" id="nome_teste1" name="associacoes['+ (length) +'].testeNome" /><input type="text" id="nome_impl1" name="associacoes['+ (length) +'].classeNome" /><a href="#" class="remove_field">Remove</a></div>'); //add input box
					    }
					    
					  });
			
					  $(wrapper).on("click", ".remove_field", function(e) { //user click on remove text
					    e.preventDefault();
					    $(this).parent('div').remove();
					    x--;
					  })
			
					});
			
				</script>
				</div>
		</div>
	</div>
</body>
</html>