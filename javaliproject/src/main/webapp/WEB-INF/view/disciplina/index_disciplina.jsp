
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
		
		<a href="/javaliproject/disciplina/removerAtividade/${disciplina.id}/${atividade.idAtividade }">remover |</a><br>
	</c:forEach>
	<a href="/javaliproject/disciplina/adicionarAtividade/${disciplina.id}">Adicionar</a>
	


 </body>
 </html>