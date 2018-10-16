<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">

<title>JS Bin</title>
<link rel="stylesheet" href="<c:url value='/css/test.css'/>">

</head>

<body>

	<div id="navbar"></div>
	<div id="ad">
		<c:forEach items="${productImage}" var="productImage">
			<c:set var="index" value="${productImage.fileId-1}" />
			<c:if test="${productImage.type eq 'ma' and productImage.fileId eq fileInfo[index].id}">
				<img class='thumbnail' src='<c:url value="${fileInfo[index].saveFileName}"/>'>
			</c:if>
		</c:forEach>
	</div>

	<ul id="category">
		<li><a href="">전체리스트&nbsp;&nbsp;</a></li>
		<c:forEach items="${category}" var="category">
			<li><a href="">${category.name}&nbsp;&nbsp;</a></li>
		</c:forEach>
	</ul>
	<article></article>
	<script src="<c:url value='/js/test.js'/>"></script>
</body>

</html>