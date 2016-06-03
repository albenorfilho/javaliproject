
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
		<a href="/javaliproject/item/index/${item.idItem}">Entrar</a><br>
	</c:forEach>
	<br>
	<a href="/javaliproject/atividade/adicionarItem/${atividade.idAtividade}">Adicionar</a>
	


 </body>
 </html>