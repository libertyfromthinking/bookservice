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
			<c:if
				test="${productImage.type eq 'ma' and productImage.fileId eq fileInfo[index].id}">
				<img class='thumbnail'
					src='<c:url value="${fileInfo[index].saveFileName}"/>'>
			</c:if>
		</c:forEach>
	</div>

	<article id="category">
		<span class="cg all">전체리스트</span> <span class="cg view">${category[0].name}</span>
		<span class="cg musical">${category[1].name }</span> <span
			class="cg concert">${category[2].name }</span> <span
			class="cg classic">${category[3].name }</span> <span
			class="cg theater">${category[4].name }</span>
	</article>
	<div id="message">
		바로 예매 가능한 전시, 공연, 행사가 <span id="ro">40개</span> 있습니다.
	</div>


	<div class="elements">
		<c:forEach items="${product}" var="product">
			<div class="element">
				<c:forEach items="${productImage}" var="productImage">
					<c:if
						test="${productImage.productId eq product.id and productImage.type eq 'ma'}">
						<c:set var="index" value="${productImage.fileId-1 }" />
						<img class="pic"
							src="<c:url value='${fileInfo[index].saveFileName}'/>">
						<br>
					</c:if>
				</c:forEach>
				<span class="title">${product.description }</span><br> <span
					class="contents">${product.content}</span>
			</div>
		</c:forEach>

	</div>
	<div id="templateex">
	
	</div>
	<footer>
		<a id="top" href="#ad">↑TOP</a>
	</footer>




	

</body>
	<script id="template" type="text/htmltemplate">
		<c:set var="a" value="id"/>
		<c:forEach items="${product}" var="product">
			<c:if test='${product.categoryId eq 3}'>
				<div class="element">
					<c:forEach items="${productImage}" var="productImage">
						<c:if
							test="${productImage.productId eq product.id and productImage.type eq 'ma'}">
							<c:set var="index" value="${productImage.fileId-1 }" />
							<img class="pic"
								src="<c:url value='${fileInfo[index].saveFileName}'/>">
							<br>
						</c:if>
					</c:forEach>
					<span class="title">${product.description }</span><br> <span
						class="contents">${product.content}</span>
				</div>
			</c:if>
		</c:forEach>
	</script>
	<script src="<c:url value='/js/test.js'/>"></script>
</html>