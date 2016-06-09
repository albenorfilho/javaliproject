
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Professor</title>
 </head>
 <body>
 
 <h1>${disciplina.nome }</h1>

<label>Descrição: ${disciplina.descricao }</label>


<h2>Atividades</h2>
	<c:forEach items="${atividades}" var="atividade">
		<label>Titulo: ${atividade.titulo }</label> | 
		<label>Descrição: ${atividade.descricao }</label> | 
		<% if(session.getAttribute("usuarioLogado")!=null) %>
		<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
		<c:if test="${tipo == 'D' || tipo=='P'}">
   		<a href="/javaliproject/disciplina/removerAtividade/${disciplina.id}/${atividade.idAtividade }">remover |</a>
  		</c:if>
		<br>
	<a href="/javaliproject/atividade/index/${atividade.idAtividade }">Entrar</a><br>
	</c:forEach>
	<c:if test="${tipo == 'D' || tipo=='P'}">
   	<a href="/javaliproject/disciplina/adicionarAtividade/${disciplina.id}">Adicionar</a><br>
  	</c:if>
	
	
	


 </body>
 </html>