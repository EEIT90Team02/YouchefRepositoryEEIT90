<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel="shortcut icon" href="/images/favicon.png"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>討論區列表</title>
</head>
<body>
	<form action="<c:url value="${request.contextPath}/pages/getessay.controller"/>"
		method="post">
		<table border="2" bordercolor="blue" >
			<thead>
				<tr>
					<td>編號</td>
					<td>發文者</td>
					<td>標題</td>
					<td>發文時間</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty list}">
					<c:forEach var="essayelement" items="${elist}">
						<tr>
							<td>${essayelement.essay_id}</td>
							<td>${essayelement.writer_id.firstName}${essayelement.writer_id.lastName}</td>
							<td>${essayelement.title}</td>
							<td>${essayelement.time}</td>			
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<p>
			<input type="submit" name="getessay" value="討論區文章">
	</form>
	<br>
</body>
</html>