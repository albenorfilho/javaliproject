
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Professor</title>
 </head>
 <body>
 
 <h1>${item.titulo}</h1>

<label>Descrição: ${item.descricao }</label>

	<form:form modelAttribute="item" id="submeterItemForm" enctype="multipart/form-data" commandName="item" servletRelativeAction="/item/submissao" method="POST">
		
		<label>Arquivo java: </label>
		<input type="hidden" name="idItem" value="${item.idItem }" />
		<input type="file" id="myfile" name="javafile" /><br>
		<input type="submit" value="Submeter!"/>
	</form:form>




 </body>
 </html>