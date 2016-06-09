<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DEUS</title>
</head>
<body>
	<h2>DEUSES</h2>
	<c:forEach items="${administrators}" var="administrator">
		<label>Admin: ${administrator.admin }</label> | 
		<label>Username: ${administrator.username }</label> | 
		
	</c:forEach>
	<a href="/javaliproject/administrator/adicionar">Adicionar</a>
</body>
</html>