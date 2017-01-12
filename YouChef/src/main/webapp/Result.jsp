<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<c:url value="${request.contextPath}/showDishes.controller?id=4001" />">台式料理</a>
<form action="<c:url value="${request.contextPath}/showDishes.controller?id=3003" />"
			method="get">
	
		<table >
			<thead>
				<tr>
					<td>照片</td>
					<td>品名</td>
					<td>價錢</td>
					<td>介紹</td>
				
				</tr>
			</thead>
			<tbody>
<%-- 				<c:if test="${not empty ob}"> --%>
					<c:forEach var="element" items="${ob}">
						<tr>
						<td>dddddd</td>
<%-- 						<c:forEach var="each" items="${ob}"  varStatus='vs'> --%>
							<td>${element.d_id}</td>
							<td>${element.dishPhotoBean.dp_id}</td>
							<td><img height='50' width='50' src='<c:url value="${request.contextPath}/getdishImage.controller?id=${element.d_id}" />'></td>	
							<td>${element}</td>
							<td>${element.price}</td>
							
							
						</tr>
					</c:forEach>
<%-- 				</c:if> --%>
			</tbody>
		</table>
		<p>
		<input type="submit">
	</form>
</body>
</html>