
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Aluno</title>
 </head>
 <body>
 
 <h1>VOCÊ É ALUNO!</h1>
 <p>Bem vindo, ${usuarioLogado.nome}! Seu id é ${usuarioLogado.id}</p>
<a href="../logout">Sair do sistema</a>

<h2>Disciplinas</h2>
	<c:forEach items="${disciplinas}" var="disciplina">
		<label>Nome: ${disciplina.nome }</label> | 
		<label>Descrição: ${disciplina.descricao }</label> | 
		
	<a href="/javaliproject/disciplina/index/${disciplina.id }">Entrar</a><br>
	</c:forEach>
	
<a href="/javaliproject/listar">Ver todas as disciplinas</a><br>

 </body>
 </html>