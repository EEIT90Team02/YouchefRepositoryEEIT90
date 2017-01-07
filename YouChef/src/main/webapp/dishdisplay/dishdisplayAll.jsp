<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>大廚餐點</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/jquery-ui.min.css"> -->

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">大廚餐點</a>
				</div>

			
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<div class="container">
		<div class="row">
		    <div class="col-md-3">
		       <div class="list-group">
  <a href="../dishdisplay/dishdisplayTaiwan.jsp" class="list-group-item">台式料理</a>
  <a href="../dishdisplay/dishdisplayJapan.jsp" class="list-group-item">日本料理</a>
  <a href="../dishdisplay/dishdisplayWestern.jsp" class="list-group-item">西式料理</a>
  <a href="../dishdisplay/dishdisplaySichuan.jsp" class="list-group-item">川味料理</a>
  <a href="../dishdisplay/dishdisplaySoutheastAsia.jsp" class="list-group-item">東南亞料理</a>
  </div>
  <div class="list-group">
					<a href="../pages/getmchef.controller" class="list-group-item">會員大廚專區</a>
				</div>
  
		    </div>
		    <div class="col-md-9">
		    <div class="jumbotron">
			
				<h3>全餐</h3>
			</div>
			<!-- 每頁不同的內容從這裡開始 -->
			<form action="<c:url value="${request.contextPath}/dishdisplay/dishview.controller" />"
			method="post">
	
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
				<c:if test="${not empty list}">
					<c:forEach var="element" items="${list}">
						<tr>
							<td><img height='50' width='50' src='<c:url value="${request.contextPath}/dishdisplay/dishview.controller?id=${element.d_id}" />'></td>
							
							<td>${element.d_name}</td>
							<td>${element.price}</td>
							<td>${element.d_briefing}</td>
							
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<p>
		<input type="submit">
	</form>
	
	<br>
              <!-- 按照jQueryUI的範例製作網頁內容 -->

			<!-- 每頁不同的內容到這裡結束 -->
		</div>
		    </div>
		</div>
</div>
		
	<!-- /container -->


	<script src="../js/jquery-1.12.3.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
<!-- 	<script src="js/jquery-ui.min.js"></script> -->
	<script>
// 	 $(function () {
//          $("#tabs").tabs({
//              event: "mouseover"
//          });

//      });
	</script>
</body>

</html>