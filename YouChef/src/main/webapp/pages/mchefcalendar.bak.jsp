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
<link href='../css/fullcalendar.min.css' rel='stylesheet' />
<!-- <link href='../fullcalendar.print.min.css' rel='stylesheet' media='print' /> -->
<script src='../js/moment.min.js'></script>
<script src='../js/jquery.min.js'></script>
<script src='../js/jquery-ui.min.js'></script>
<script src='../js/fullcalendar.min.js'></script>
<script src='../js/locale-all.js'></script>
<script src='../js/moment.min.js'></script>
<script>
	$(document).ready(function() {

		/* initialize the external events
		-----------------------------------------------------------------*/

		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title : $.trim($(this).text()), // use the element's text as the event title
				stick : true
			// maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex : 999,
				revert : true, // will cause the event to go back to its
				revertDuration : 0
			//  original position after the drag
			});

		});

		/* initialize the calendar
		-----------------------------------------------------------------*/

		$('#calendar').fullCalendar({
			locale: 'zh-tw',
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay'
			},
			editable : true,
			droppable : true, // this allows things to be dropped onto the calendar
			drop : function() {
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
			}
		});

	});
</script>
<style>
body {
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#wrap {
	width: 1100px;
	margin: 0 auto;
}

#external-events {
	float: left;
	width: 200px;
	padding: 0 5px;
	border: 1px solid #ccc;
	background: #eee;
	text-align: center;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

#external-events .fc-event {
	margin: 10px 30px;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar {
	float: right;
	width: 850px;
}
</style>
<title>大廚行事曆</title>
</head>
<body>
	<div id='wrap'>
<!-- 		<div> -->
		<table id='external-events'>
			<tr>
				<td><h4>${bean.memberBean.firstName}${bean.memberBean.lastName}</h4></td>
			</tr>
			<tr>
				<td><img height='100' width='80'
					src='<c:url value="${request.contextPath}/pages/getImage.controller?mc_id=${bean.mc_id}" />'></td>
			</tr>
			<tr>
				<td>
				<hr>
					<div>
						<h5>非營業時段</h5>
						<div class='fc-event'>中午</div>
						<div class='fc-event'>晚上</div>
						<div class='fc-event'>整日</div>
					</div>
				</td>
			</tr>
			<tr></tr><tr></tr><tr></tr>
			<tr>
				<td><a href="#" >確定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" >回上頁</a></td>
			</tr>
		</table>
<!-- 		</div> -->

		<div id='calendar'></div>

		<div style='clear: both'></div>

	</div>
	<!-- <hr> -->
</body>
</html>