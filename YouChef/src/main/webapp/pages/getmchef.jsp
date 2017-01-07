<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="../images/favicon.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<title>會員大廚列表</title>
</head>
<body bgcolor="white">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				dddfgdfgdfgdsfgdfgdfgd
			</div>
			<div class="span10">
				dfgadfdafgdafgdafgadfdfgadfdafgdafgdafgadfdfgadfdafgdafgdafgadfdfgadfdafgdafgdafgadfdfgadfdafgdafgdafgadfdfgadfdafgdafgdafgadf
			</div>
		</div>
	</div>
	<form
		action="<c:url value="${request.contextPath}/pages/getmchef.controller?mc_id=1002" />"
		method="post">
		<input type="submit" name="getmchef" value="會員大廚列表">
	</form>
	<br>
</body>
</html>