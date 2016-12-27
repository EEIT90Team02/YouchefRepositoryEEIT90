<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抓出來呈現</title>
</head>

<body>
	<form action="<c:url value="${request.contextPath}/pages/getessay.controller"/>" method="POST">
	<table border="2">
		<thead>
			<tr>
				<td>編號</td>
				<td>發文者</td>
				<td>標題</td>
				<td>發文時間</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty elist}">
			<c:forEach var="element" items="${elist}">
				<tr>
				<td>${element.essay_id}</td>
				<td>${element.writer_id.firstName}${element.writer_id.lastName}</td>
				<td><a href="path">${element.title}</a></td>
				<td>${element.time}</td>
				</tr>
			</c:forEach>
			</c:if>
		</tbody>	
	</table>
	<p>
	<input type="submit" name="insertessay" value="發文章">
	<input type="submit" name="getessay" value="討論區文章">
	
	</form>
</body>
</html>