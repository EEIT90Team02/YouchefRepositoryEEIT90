<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

<style type="text/css">
	#r_stars01{
			visibility:hidden;
			}	
</style>

<title>訂單詳情</title>
</head>
<body>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
	<h3>訂單詳情</h3>
	
	<table class="table table-hover table-curved" style="font-size:120%;font-weight:600;">
		<thead>
			<tr>
				<th>訂單號碼</th>
				<th>廚師姓名</th>
				<th>餐點名稱</th>
				<th>數量</th>
				<th>單價</th>
				<th>套餐</th>
				<th>總金額</th>
				<th>菜系</th>
			</tr>
		</thead>
		<tbody style="font-size: 80%;">
			<c:forEach var="element" items="${orderDetail}">
				<tr class="warning">
					<td>${element[1]}</td>
					<td>${element[2]}${element[3]}${element[4]}	${element[5]}</td>
					<td>${element[6]}</td>
					<td>${element[7]}</td>
					<td>${element[8]}</td>
					<td>${element[9]}</td>
					<td>${element[10]}</td>
					<td>${element[11]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<span style=" float:right;">
		
		<a href="<c:url value="/cancelOrder.controller?o_id=${param.o_id}&o_status=1"/>" class="btn btn-danger">取消訂單</a> 
		<br>
		<c:choose>
			<c:when test="${o_status == 2 }">
			訂單完成, 麻煩請評價一下!
			<button id="reviewBtn" class="btn btn-success">評價</button>
			</c:when>
		</c:choose>

	</span>
	
	<div id="review" style="display:none">
	<H4>請給予評價</H4>
		<c:choose>
			<c:when test="${not empty errors}">
				<script>
					alert('${errors.reviewcontent}');			
				</script>
			</c:when>
		</c:choose>
<form action="<c:url value="${request.contextPath}/review/updateorderreview.controller?o_id=${param.o_id}"/>" method="POST"> 
    	<div><label class="title">滿意度:</label><br>
    	<img id="p1" src="<c:url value="/images/stars/starsoff.png"/>" />
    	<img id="p2" src="<c:url value="/images/stars/starsoff.png"/>" />
    	<img id="p3" src="<c:url value="/images/stars/starsoff.png"/>" />
    	<img id="p4" src="<c:url value="/images/stars/starsoff.png"/>" />
    	<img id="p5" src="<c:url value="/images/stars/starsoff.png"/>" /><span id="rate"></span>
<!--     	<input type="text" value="" name=r_stars id="stars"> -->
    	<input id="r_stars01" name="r_stars" >
		
    	</div>
    <div>
		<label class="title">評價內容:</label><p>
		<textarea cols="40" rows="10" name="r_message"></textarea>
	</div>
	<p>
	<input type="reset" value="清除內容">
	<input type="submit" name="inessay" value="發表評價">    
	</p>
</form>
</div>  
</div>
</div>

	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#reviewBtn").click(function(){
				$("#review").slideToggle();
			});
		});
	</script>

	<script type="text/javascript">
var flag = false;
var starAry;
document.addEventListener("DOMContentLoaded",function () {
//     var imgs = document.getElementsByTagName("img");
//     alert("imgs.length = " + imgs.length);
    starAry = new Array(5);
    for (var i = 0; i < starAry.length; i++) {
//         starAry[i] = imgs[i].id;
//         imgs[i].addEventListener("mouseover",function () { mouseOver(this.id);});
//         imgs[i].addEventListener("click",function () { Click(this.id);});
        starAry[i] = "p" + (i+1);
        document.getElementById(starAry[i]).addEventListener("mouseover",function () { mouseOver(this.id);});
        document.getElementById(starAry[i]).addEventListener("click",function () { Click(this.id);});
    }
});
function mouseOver(imgid) {
if (!flag) {
        var index = starAry.indexOf(imgid);
        var fox = (index+1);
        for (var i = 0; i <= index; i++) {
//         	alert(document.getElementById(starAry));
;//         	alert(document.getElementById(starAry[i]));
            document.getElementById(starAry[i]).src = "<c:url value='images/stars/starson.png'/>";
        }
        if (index < starAry.length - 1) {
            for (var i = index + 1; i < starAry.length; i++) {
                document.getElementById(starAry[i]).src = "<c:url value='images/stars/starsoff.png'/>";
            }
        }
        document.getElementById("rate").innerHTML = "評分中..." + fox;
    }
}

function Click(imgid) {
    if (!flag) {
        flag = true;
        var index = starAry.indexOf(imgid);
        var fox = (index+1);
        var getStar_element = document.getElementById("stars");
//         getStar_element.value=fox;
        document.getElementById("rate").innerHTML = "選定了"+fox + "顆星";
        document.getElementById("r_stars01").value=fox;   
    }     
}
</script>		

</body>
</html>