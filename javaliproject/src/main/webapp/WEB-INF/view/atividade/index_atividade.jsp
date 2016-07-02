
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Professor</title>
 </head>
 <body>
 
 <h1>${atividade.titulo }</h1>

<label>Descrição: ${atividade.descricao }</label>


<h2>Itens</h2>
	<c:forEach items="${itens}" var="item">
		<label>Titulo: ${item.titulo }</label> | 
		<label>Descrição: ${item.descricao}</label> | <br>
		<% if(session.getAttribute("usuarioLogado")!=null) %>
		<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
		<c:if test="${tipo == 'A'}">
  		<a href="/javaliproject/item/submissao/${item.idItem}">Adicionar Submissão</a><br>
  		</c:if>
		
	</c:forEach>
	<br>
	<% if(session.getAttribute("usuarioLogado")!=null) %>
		<c:set var="tipo" scope="session" value="${usuarioLogado.tipo}"/>
		<c:if test="${tipo == 'D' || tipo=='P'}">
   		<a href="/javaliproject/atividade/adicionarItem/${atividade.idAtividade}">Adicionar</a>
  		</c:if>
	<!-- 
	<form:form id="adicionarSubmissaoItemForm" enctype="multipart/form-data" commandName="item" servletRelativeAction="/atividade/adicionarSubmissaoItem" method="POST">
		<label>Arquivo java: </label>
		<input type="file" id="myfile" name="javafile" /><br>
		
		<input type="submit" value="Adicionar"/>
	</form:form>

 -->
 </body>
 </html>