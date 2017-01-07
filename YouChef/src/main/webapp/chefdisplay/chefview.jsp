dishdisplay<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>大廚上菜</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/jquery-ui.min.css"> -->
<script type="text/javascript">
            function $(id) { return document.getElementById(id); }

            function addLoadEvent(func){
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function(){
			oldonload();
			func();
		}
	}
}

function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem = document.getElementById(elementID);
  if (elem.movement) {
    clearTimeout(elem.movement);
  }
  if (!elem.style.left) {
    elem.style.left = "0px";
  }
  if (!elem.style.top) {
    elem.style.top = "0px";
  }
  var xpos = parseInt(elem.style.left);
  var ypos = parseInt(elem.style.top);
  if (xpos == final_x && ypos == final_y) {
		return true;
  }
  if (xpos < final_x) {
    var dist = Math.ceil((final_x - xpos)/10);
    xpos = xpos + dist;
  }
  if (xpos > final_x) {
    var dist = Math.ceil((xpos - final_x)/10);
    xpos = xpos - dist;
  }
  if (ypos < final_y) {
    var dist = Math.ceil((final_y - ypos)/10);
    ypos = ypos + dist;
  }
  if (ypos > final_y) {
    var dist = Math.ceil((ypos - final_y)/10);
    ypos = ypos - dist;
  }
  elem.style.left = xpos + "px";
  elem.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem.movement = setTimeout(repeat,interval);
}

function classNormal(iFocusBtnID,iFocusTxID){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
	var iFocusTxs = $(iFocusTxID).getElementsByTagName('li');
	for(var i=0; i<iFocusBtns.length; i++) {
		iFocusBtns[i].className='normal';
		iFocusTxs[i].className='normal';
	}
}

function classCurrent(iFocusBtnID,iFocusTxID,n){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
	var iFocusTxs = $(iFocusTxID).getElementsByTagName('li');
	iFocusBtns[n].className='current';
	iFocusTxs[n].className='current';
}

function iFocusChange() {
	if(!$('ifocus')) return false;
	$('ifocus').onmouseover = function(){atuokey = true};
	$('ifocus').onmouseout = function(){atuokey = false};
	var iFocusBtns = $('ifocus_btn').getElementsByTagName('li');
	var listLength = iFocusBtns.length;
	iFocusBtns[0].onmouseover = function() {
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (listLength>=2) {
		iFocusBtns[1].onmouseover = function() {
			moveElement('ifocus_piclist',0,-225,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',1);
		}
	}
	if (listLength>=3) {
		iFocusBtns[2].onmouseover = function() {
			moveElement('ifocus_piclist',0,-450,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',2);
		}
	}
	if (listLength>=4) {
		iFocusBtns[3].onmouseover = function() {
			moveElement('ifocus_piclist',0,-675,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',3);
		}
	}
}

setInterval('autoiFocus()',3500);
var atuokey = false;
function autoiFocus() {
	if(!$('ifocus')) return false;
	if(atuokey) return false;
	var focusBtnList = $('ifocus_btn').getElementsByTagName('li');
	var listLength = focusBtnList.length;
	for(var i=0; i<listLength; i++) {
		if (focusBtnList[i].className == 'current') var currentNum = i;
	}
	if (currentNum==0&&listLength!=1 ){
		moveElement('ifocus_piclist',0,-225,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',1);
	}
	if (currentNum==1&&listLength!=2 ){
		moveElement('ifocus_piclist',0,-450,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',2);
	}
	if (currentNum==2&&listLength!=3 ){
		moveElement('ifocus_piclist',0,-675,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',3);
	}
	if (currentNum==3 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (currentNum==1&&listLength==2 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (currentNum==2&&listLength==3 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
}
addLoadEvent(iFocusChange);
</script>
<style type="text/css">
        *{padding:0px;
          margin:0px;
          }
        #ifocus { width:592px; height:229px; margin-left:5px;margin-top:5px; border:1px solid #DEDEDE; background:#F8F8F8; border-top-left-radius:8px;border-top-right-radius:8px;}
	    #ifocus_pic { display:inline; position:relative; float:left; width:672px; height:225px; overflow:hidden; margin:2px 0 0 2px; }
		#ifocus_piclist { position:absolute; }
		#ifocus_piclist li { width:520px; height:225px; overflow:hidden; }
		#ifocus_piclist img { width:520px; height:225px; }
	    #ifocus_btn { display:inline; float:right; width:91px; margin:2px 68px 0 0; }
		#ifocus_btn li { width:81px; height:57px; cursor:pointer; opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50); }
		#ifocus_btn img { width:65px; height:45px; margin:7px 0 0 11px; }
		#ifocus_btn .current {background:url("../image/jixiang.gif") no-repeat; -moz-opacity:100; filter:alpha(opacity=100); }
	    #ifocus_opdiv { position:absolute; left:0; bottom:0; width:520px; height:25px; background:#000; opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50); }
	    #ifocus_tx { position:absolute; left:8px; bottom:8px; color:#DDDEED; }
		#ifocus_tx .normal { display:none; }
		ul{list-style-type:none;}
</style>
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
					<a class="navbar-brand" href="#">大廚上菜</a>
				</div>

			
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<div class="container">
		<div class="row">
		    <div class="col-md-3">
		       <div class="list-group">
  <a href="../chefdisplay/chefdisplayAll.jsp" class="list-group-item">全部大廚</a>
  <a href="../chefdisplay/chefdisplayTaiwan.jsp" class="list-group-item">台式料理</a>
  <a href="../chefdisplay/chefdisplayJapan.jsp" class="list-group-item">日本料理</a>
  <a href="../chefdisplay/chefdisplayWestern.jsp" class="list-group-item">西式料理</a>
  <a href="../chefdisplay/chefdisplaySichuan.jsp" class="list-group-item">川味料理</a>
  <a href="../chefdisplay/chefdisplaySoutheastAsia.jsp" class="list-group-item">東南亞料理</a>

  
</div>
		    </div>
		    <div class="col-md-9">
		    <div class="jumbotron">
				<h3>大廚介紹</h3>
			</div>
			<div id="ifocus">
<div id="ifocus_pic">
	<div id="ifocus_piclist" style="left:0; top:0;">
		<ul>
			<li><a href="#"><img src="../images/product/1.JPG" alt="1" border="0" /></a></li>
			<li><a href="#"><img src="../images/product/2.JPG" alt="2" border="0"/></a></li>
			<li><a href="#"><img src="../images/product/3.JPG" alt="3" border="0" /></a></li>
			<li><a href="#"><img src="../images/product/4.JPG" alt="4" border="0" /></a></li>
	    </ul>
   </div>
   <div id="ifocus_opdiv"></div>
   <div id="ifocus_tx">
		<ul>
			<li class="current"></li>
			<li class="normal"></li>
			<li class="normal"></li>
			<li class="normal"></li>
		</ul>
   </div>
   <div id="ifocus_btn">
	    <ul>
	        <li class="current"><img src="../images/product/1.JPG" alt="1" /></li>
			<li class="normal"><img src="../images/product/2.JPG" alt="2" /></li>
	    	<li class="normal"><img src="../images/product/3.JPG" alt="3" /></li>
	    	<li class="normal"><img src="../images/product/4.JPG" alt="4" /></li>
		</ul>
   </div>
</div>
</div>
			<!-- 每頁不同的內容從這裡開始 -->
			<form action="<c:url value="${request.contextPath}/chefdisplay/chefview.controller" />"
			method="post">
<table  class="table table-striped">
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<td>照片</td> -->
<!-- 					<td>大廚姓名</td> -->
<!-- 					<td>背景</td> -->
<!-- 					<td>菜系</td> -->
<!-- 					<td>年資</td> -->
<!-- 				</tr> -->
<!-- 			</thead> -->
			<tbody>
						<tr>
							<td><img height='80' width='80' src='<c:url value="${request.contextPath}/pages/getImage.controller?id=${chef.c_id}" />'></td>
							<td>${chef.lastName}${chef.firstName}</td>
							<td>${chef.background}</td>
							<td>${chef.typeBean.t_name}</td>
							<td>${chef.years}</td>
							
						</tr>
			</tbody>
		</table>
		<p>
		
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