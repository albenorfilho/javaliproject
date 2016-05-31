
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Professor</title>
 </head>
 <body>
 
 <h1>VOCÊ É ALUNO!</h1>
<p>Bem vindo, ${usuarioLogado.nome}! Seu id é ${usuarioLogado.id}</p>
 <a href="logout">Sair do sistema</a>
 </body>
 </html>